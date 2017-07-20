package com.molyo;

import org.tensorflow.Operation;
import org.tensorflow.Output;
import org.tensorflow.Shape;

/**
 * Created by hongchong on 2017/7/12.
 */
public class HelloWorld {
    public static void main(String[] args) {
        String labels = "17,16,7,8,3,15,4,14,2,5,12,18,9,10,1,11,13,6";

        TensorFlowInferenceInterface tfi = new TensorFlowInferenceInterface("D:/tf_mode/output_graph.pb", "imageType");
        final Operation operation = tfi.graphOperation("y_conv_add");
        Output output = operation.output(0);
        Shape shape = output.shape();
        final int numClasses = (int) shape.size(1);
        float[] floatValues = getImagePixel("D:/tf_mode/ci/ci/333.jpg"); //将图片处理为输入对应张量格式

        // 输入图片
        tfi.feed("x_input", floatValues, 1, 2048); //将数据复制给输入张量x_input即为模型定义时的x名称
        tfi.run(new String[]{"y_conv_add"}, false);//输出张量
        float[] outPuts = new float[numClasses];//结果分类
        tfi.fetch("y_conv_add", outPuts);//接收结果 outPuts保存的即为预测结果对应的概率，最大的一个通常为本次预测结果
    }
}
