<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>3T SPORT EQUIPMENTS</title>
        <link rel="shortcut icon" type="image/x-icon" href="../resource/client/img/runningman.png">
        <link rel="stylesheet" type="text/css" href="resource/common/authen.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
        <script>
            $(document).on('click', '.toggle-password', function () {
                $(this).toggleClass("fa-eye fa-eye-slash");
                var input = $("#pass_log_id");
                input.attr('type') === 'password' ? input.attr('type', 'text') : input.attr('type', 'password')
            });
        </script>
    </head>
    <body style="background: url(resource/client/img/background_sport.jpg); background-size: 100% 230%; background-repeat: no-repeat">
        <!-- Authen form -->
        <div class="auth-form" style="background-color: white;">
            <form action="register" method="post">
                <div class="auth-form-container">
                    <div class="auth-form-header">
                        <h3 class="auth-form-title">Đăng ký</h3>
                        <a href="login" class="auth-form-subtitle">Đăng nhập</a>
                    </div>
                    <p style="color: red; margin-top: -20px; margin-left: 3x; margin-bottom: 5px;">${error}</p>

                    <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="select" class=" form-control-label">Email:</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input required="required" type="email" class="form-control"
                                                       placeholder="Nhập email của bạn..." name="email" />
                                            </div>
                                            <a style = "color:red">${message }</a>
                                        </div>

                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="text-input" class=" form-control-label">Họ
                                                    và tên:</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input required="required" type="text" class="form-control" style="height: 30px;"
                                                       placeholder="Nhập họ và tên..." name="fullName" />
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="email-input" class=" form-control-label">Giới
                                                    tính:</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="radio" checked="checked" name="gender"
                                                       value="true" style="cursor: pointer;" /> <span
                                                       style="margin-right: 100px;">Nam</span> <input type="radio"
                                                       name="gender" value="false" style="cursor: pointer;" />
                                                Nữ
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="password-input" class=" form-control-label">Số
                                                    điện thoại</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input required="required" type="text" class="form-control"
                                                       placeholder="Nhập số điện thoại của bạn..." name="phone" />
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="disabled-input" class=" form-control-label">Địa
                                                    chỉ</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <textarea required="required" class="form-control"
                                                          placeholder="Nhập địa chỉ của bạn..." rows="4"
                                                          name="address"></textarea>
                                            </div>
                                        </div>
                                        <div class="row form-group" hidden>
                                            <div class="col col-md-3">
                                                <label for="disabled-input" class=" form-control-label">Vai
                                                    trò</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                
                                                <input type="text" name="roleId" size=20 readonly="true" value="3">
                                            </div>
                                        </div>

                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label class=" form-control-label">Mật khẩu</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input required="required" type="password"
                                                       class="form-control" style="height: 30px;"
                                                       placeholder="Mật khẩu của bạn..." name="password" />
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label class=" form-control-label">Nhập lại mật khẩu</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input required="required" type="password"
                                                       class="form-control" style="height: 30px;"
                                                       placeholder="Nhập lại mật khẩu..." name="repassword" />
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="file-input" class=" form-control-label"></label>
                                            </div>
                                            
                                        </div>

                    <div class="auth-form-controls">
                        <a href="client/home" class="btn">Quay lại</a> <button type="submit" style="cursor: pointer;"
                                                                               class="btn">Đăng ký</button>
                    </div>
                </div>
            </form>
            <div class="auth-form-social">
                <a
                    href="#" class="btn-social-gg"><i class='fa'
                                                  style='font-size: 20px; color: tomato'>&#xf2b3;</i> Đăng nhập với
                    Google </a>
                <a href="#" class="btn-social-fb"><i class='fa'
                                                     style="font-size: 20px;">&#xf09a;</i> Đăng nhập với Facebook </a> 
            </div>
        </div>
    </body>
</html>