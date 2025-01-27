<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>3T Sport - Adminin</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="../resource/client/img/runningman.png">
        <link rel="shortcut icon" type="image/x-icon" href="../resource/client/img/runningman.png">">

        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
        <link rel="stylesheet"
              href="<c:url value='../resource/admin/assets/css/cs-skin-elastic.cs'/>">
        <link rel="stylesheet"
              href="<c:url value='../resource/admin/assets/css/lib/datatable/dataTables.bootstrap.min.css'/>">
        <link rel="stylesheet"
              href="<c:url value='../resource/admin/assets/css/style.css'/>">
        <link
            href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
            rel='stylesheet' type='text/css'>
    </head>
    <body>
        <%@include file="../common/category.jsp"%>
        <%-- <jsp:include page="../common/category.jsp" /> --%>

        <div id="right-panel" class="right-panel">

            <jsp:include page="../common/header.jsp" />

            <div class="content">
                <div class="animated fadeIn">
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <div class="card border border-secondary">
                                <div class="card-header">
                                    <strong class="card-title">Thêm sản phẩm</strong>
                                </div>
                                <div class="card-body card-block">

                                    <form action="product-create" method="post"
                                          enctype="multipart/form-data" class="form-horizontal">
                                        <c:if test="${product != null}">
                                            <input type="hidden" name="id"
                                                   value="<c:out value='${product.productId}' />" />
                                        </c:if>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="select" class=" form-control-label">Loại
                                                    sản phẩm</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <select name="categoryId">
                                                    <c:forEach items="${categories}" var="category">
                                                        <option value="${category.categoryId}">${category.categoryName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="text-input" class=" form-control-label">Tên
                                                    sản phẩm</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input required="required" type="text" id="text-input"
                                                       name="productName" placeholder="Nhập tên sản phẩm..."
                                                       class="form-control">
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="email-input" class=" form-control-label">Mô
                                                    tả sản phẩm</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <textarea required="required" id="email-input"
                                                          name="description" rows="4"
                                                          placeholder="Nhập mô tả của sản phẩm..."
                                                          class="form-control"></textarea>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="password-input" class=" form-control-label">Giá
                                                    sản phẩm</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" required="required" name="price"
                                                       placeholder="0.00 VNĐ" class="form-control">
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="disabled-input" class=" form-control-label">Số
                                                    lượng</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" required="required" name="quantity"
                                                       placeholder="0" class="form-control">
                                            </div>
                                        </div>

                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="file-input" class=" form-control-label">Hình
                                                    ảnh</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="file" required="required" name="imageFile"
                                                       class="form-control-file">
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label class=" form-control-label">Giảm giá</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <select name="saleId">
                                                    <c:forEach items="${sales}" var="sale">
                                                        <option value="${sale.saleId}">${sale.percent}%</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="file-input" class=" form-control-label"></label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <button type="submit" class="btn btn-success">Thêm</button>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                </div>
            </div>
            <!-- END MAIN -->
            <div class="clearfix"></div>
            <!-- Footer -->
            <footer class="site-footer">
                <div class="footer-inner bg-white">
                    <div class="row">
                        <div class="col-sm-6">&copy; 2021</div>
                        <div class="col-sm-6 text-right">
                            Website được thực hiện bởi <a href="https://colorlib.com">3T ADMIN</a>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
        <!-- Scripts -->
        <script
        src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
        <script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
        <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
        <script
        src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
        <script src="../resource/admin/assets/js/main.js"></script>
    </body>
</html>