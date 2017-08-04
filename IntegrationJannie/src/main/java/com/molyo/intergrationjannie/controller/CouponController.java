package com.molyo.intergrationjannie.controller;

import com.molyo.intergrationjannie.model.CouponModel;
import com.molyo.intergrationjannie.service.ICouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by hongchong on 2017/8/4.
 */
@Controller
@RequestMapping("/coupon")
public class CouponController {
    private static Logger logger = LoggerFactory.getLogger(CouponController.class);
    @Resource
    private ICouponService couponService;

    @Transactional
    @RequestMapping("/success")
    public String toIndex(HttpServletRequest request, Model model) throws Exception {

        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        logger.info("此次用户ip为：" + ip);

        CouponModel havedCouponModel = couponService.selectByIp(ip);
        if(havedCouponModel != null) {
            logger.info("");
            model.addAttribute("reason","抱歉，一个IP仅允许获得一个兑换码");
            return "nocoupon";
        }

        CouponModel newCouponModel = couponService.findUnused();
        if(newCouponModel == null) {
            model.addAttribute("reason","抱歉，您来晚了一步，活动礼物已派送完");
            return "nocoupon";
        }
        newCouponModel.setIp(ip);
        newCouponModel.setIsused("1");
        newCouponModel.setFetchtime(new Date().toString());
        couponService.updateByPrimaryKey(newCouponModel);
        model.addAttribute("coupon",newCouponModel);
        return "coupondetail";
    }
}
