<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <!-- Header-->
        <header id="header" class="header">
            <div class="top-left">
                <div class="navbar-header">
                    <a class="navbar-brand" href="home"><img src="../resource/admin/assets/images/3tadmin2.png" alt="Logo"></a>

                    <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
                </div>
            </div>
            <div class="top-right">
                <div class="header-menu">
                    <div class="header-left">
                        <button class="search-trigger"><i class="fa fa-search"></i></button>
                        <div class="form-inline">
                            <form class="search-form">
                                <input class="form-control mr-sm-2" type="text" placeholder="Bạn tìm kiếm điều gì ..." aria-label="Search">
                                <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                            </form>
                        </div>

                        <div class="dropdown for-notification">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="notification" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-bell"></i>
                                <span class="count bg-danger">3</span>
                            </button>
                            <div class="dropdown-menu" aria-labelledby="notification">
                                <p class="red">Bạn có 3 thông báo</p>
                                <a class="dropdown-item media" href="#">
                                    <i class="fa fa-check"></i>
                                    <p>Máy chủ số 1 bị quá tải.</p>
                                </a>
                                <a class="dropdown-item media" href="#">
                                    <i class="fa fa-info"></i>
                                    <p>Máy chủ số 2 bị quá tải.</p>
                                </a>
                                <a class="dropdown-item media" href="#">
                                    <i class="fa fa-warning"></i>
                                    <p>Máy chủ số 3 bị quá tải.</p>
                                </a>
                            </div>
                        </div>

                        <div class="dropdown for-message">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="message" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-envelope"></i>
                                <span class="count bg-primary">4</span>
                            </button>
                            <div class="dropdown-menu" aria-labelledby="message">
                                <p class="red">Bạn có 4 tin nhắn</p>
                                <a class="dropdown-item media" href="#">
                                    <span class="photo media-left"><img alt="avatar" src="../resource/admin/assets/images/avatar/tan.jpg"></span>
                                    <div class="message media-body">
                                        <span class="name float-left">Trần Thái Minh Tân</span>
                                        <span class="time float-right">Vừa xong</span>
                                        <p>Xin chào, đây là một tin nhắn ví dụ</p>
                                    </div>
                                </a>
                                <a class="dropdown-item media" href="#">
                                    <span class="photo media-left"><img alt="avatar" src="../resource/admin/assets/images/avatar/tri.jpg"></span>
                                    <div class="message media-body">
                                        <span class="name float-left">Nguyễn Ngọc Trí</span>
                                        <span class="time float-right">5 phút trước</span>
                                        <p>Xin chào, đây là một tin nhắn ví dụ</p>
                                    </div>
                                </a>
                                <a class="dropdown-item media" href="#">
                                    <span class="photo media-left"><img alt="avatar" src="../resource/admin/assets/images/avatar/toan.jpg"></span>
                                    <div class="message media-body">
                                        <span class="name float-left">Phùng Thanh Toàn</span>
                                        <span class="time float-right">10 phút trước</span>
                                        <p>Xin chào, đây là một tin nhắn ví dụ</p>
                                    </div>
                                </a>
                                <a class="dropdown-item media" href="#">
                                    <span class="photo media-left"><img alt="avatar" src="../resource/admin/assets/images/avatar/4.jpg"></span>
                                    <div class="message media-body">
                                        <span class="name float-left">Nguyễn Thị Sen</span>
                                        <span class="time float-right">15 phút trước</span>
                                        <p>Xin chào, đây là một tin nhắn ví dụ</p>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="user-area dropdown float-right">
                        <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img class="user-avatar rounded-circle" src="data:image/jpg;base64,${sessionScope.user.avatar}" alt="User Avatar">
                        </a>

                        <div class="user-menu dropdown-menu">
                            <a class="nav-link" href="#"><i class="fa fa- user"></i>Thông tin của tôi</a>

                            <a class="nav-link" href="#"><i class="fa fa- user"></i>Thông báo<span class="count">13</span></a>

                            <a class="nav-link" href="#"><i class="fa fa -cog"></i>Cài đặt</a>

                            <a class="nav-link" href="../login"><i class="fa fa-power -off"></i>Đăng xuất</a>
                        </div>
                    </div>

                </div>
            </div>
        </header>
        <!-- /#header -->
    </body>
</html>