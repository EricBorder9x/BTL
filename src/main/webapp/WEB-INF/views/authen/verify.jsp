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
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body style="background: url(resource/client/img/background_sport.jpg); background-size: 100% 250%; background-repeat: no-repeat">
        <!-- Authen form -->
        <form action="verify" method="post">
            <div class="auth-form" style="background-color: white;">
                <div class="auth-form-container">
                    <a href="client/home"><h5 class="auth-form-title"
                                              style="text-align: center; padding-top: 20px;">Chào mừng đến với <br> 3T Sport Equipments</h5></a>
                    <hr style="margin-top: -35px;" />
                    <p style="font-size: 18px; text-align: center;">
                        Chúng tôi vừa gửi một mã xác nhận tới <span
                            style="font-weight: bold;">${sessionScope.emailRegister}</span>
                    </p>
                    <div class="auth-form-form"
                         style="margin-top: 15px; margin-bottom: -13px;">
                        <div class="auth-form-group">
                            <c:if test="${resend != null}">
                                <div style="display: flex; margin-bottom: 2px; color: #0101DF;">
                                    <i class="material-icons" style="font-size: 19px;">&#xe88f;</i>
                                    <span>Kiểm tra mail của bạn.</span>
                                </div>
                            </c:if>

                            <c:if test="${verifyFail != null}">
                                <div style="display: flex; margin-bottom: 2px; color: red;">
                                    <i style="font-size:18px" class="fa">&#xf071;</i>
                                    <span style="margin-left: 2px;">${verifyFail}</span>
                                </div>
                            </c:if>

                            <c:if test="${verifySuccess != null}">
                                <div style="display: flex; margin-bottom: 2px; color: #339900;">
                                    <i style='font-size:19px' class='fa'>&#xf058;</i>
                                    <span>${verifySuccess}</span> <a href="login" style="margin-left: 10px;">Đăng nhập ngay</a>
                                </div>
                            </c:if>

                            <input class="auth-form-input" type="text" name="code" id="pass_log_id"
                                   placeholder="Nhập mã" required="required" />
                        </div>
                    </div>
                    <div style="font-size: 17px; text-align: center;">
                        <span>Không nhận được mã ? <a href="resend-code">Gửi lại mã cho tôi.</a>
                        </span>
                    </div>
                    <div class="auth-form-controls"
                         style="margin-top: 15px;">
                        <button type="submit" class="btn-1" style="cursor: pointer;">Xác nhận</button>
                    </div>
                    <div style="padding-bottom: 20px;"></div>
                </div>
            </div>
        </form>
    </body>
</html>
