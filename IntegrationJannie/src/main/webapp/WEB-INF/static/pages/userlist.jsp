<%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">用户管理</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">新增用户</h4>
                        </div>
                        <div class="modal-body">
                            <form action="/user/add" method="post" >
                                <div class="form-group">
                                    <label>用户名</label>
                                    <input id="username" name="username" class="form-control">
                                    <p class="help-block">用户名由英文及数字组成.</p>
                                </div>
                                <div class="form-group">
                                    <label>密码</label>
                                    <input id="password" name="password" class="form-control" placeholder="Enter text">
                                </div>

                                <div class="form-group">
                                    <label>所属机构</label>
                                    <select class="form-control" name="salt" id="salt">
                                        <option value="1">分公司1</option>
                                        <option value="2">分公司2</option>
                                        <option value="3">分公司3</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>角色列表</label>
                                    <select multiple="multiple" class="form-control" >
                                        <option>超级管理员</option>
                                        <option>普通用户</option>
                                        <option>普通管理员</option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-default">新增</button>
                                <button type="reset" class="btn btn-default">清空</button>
                            </form>

                        </div>
                        <%--<div class="modal-footer">--%>
                            <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                            <%--<button type="button" class="btn btn-primary">Save changes</button>--%>
                        <%--</div>--%>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>

            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        DataTables Advanced Tables <button type="button" class="btn btn-primary" >新增用户</button>
                        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                            Launch Demo Modal
                        </button>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>用户名称</th>
                                <th>用户名称</th>
                                <th>用户名称</th>
                                <th>用户名称</th>
                                <th>用户名称</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="odd gradeX">
                                <td>Trident</td>
                                <td>Internet Explorer 4.0</td>
                                <td>Win 95+</td>
                                <td class="center">4</td>
                                <td class="center">X</td>
                            </tr>
                            <tr class="even gradeC">
                                <td>Trident</td>
                                <td>Internet Explorer 5.0</td>
                                <td>Win 95+</td>
                                <td class="center">5</td>
                                <td class="center">C</td>
                            </tr>
                            <tr class="odd gradeA">
                                <td>Trident</td>
                                <td>Internet Explorer 5.5</td>
                                <td>Win 95+</td>
                                <td class="center">5.5</td>
                                <td class="center">A</td>
                            </tr>
                            </tbody>
                        </table>
                        <!-- /.table-responsive -->
                        <div class="well">
                            <h4>DataTables Usage Information</h4>
                            <p>DataTables is a very flexible, advanced tables plugin for jQuery. In SB Admin, we are using a specialized version of DataTables built for Bootstrap 3. We have also customized the table headings to use Font Awesome icons in place of images. For complete documentation on DataTables, visit their website at <a target="_blank" href="https://datatables.net/">https://datatables.net/</a>.</p>
                            <a class="btn btn-default btn-lg btn-block" target="_blank" href="https://datatables.net/">View DataTables Documentation</a>
                        </div>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->

    </div>
    <!-- /#page-wrapper -->

