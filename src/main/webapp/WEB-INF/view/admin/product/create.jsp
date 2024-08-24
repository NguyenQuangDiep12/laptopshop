
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" 
    integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" 
    crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="/css/create.css">
    <script>
      $(document).ready(() => {
        const avatarFile = $('#avatarFile');
        avatarFile.change(  (e) => {
          const imgURL = URL.createObjectURL(e.target.files[0])
          $('#avatarPreview').attr('src' , imgURL)
          $('#avatarPreview').css({"display": "block"})
        })
      })
    </script>
</head>
<body>
    <div class="mt-5">
        <div class="row">
            <div class="col-md-6 col-12 mx-auto">
                <h3>Create a product</h3>
                <hr/>
                <form:form method="post" action="/admin/product/create" class="row" modelAttribute="newProduct" enctype="multipart/form-data">
                    <!-- check invalid -->
                     <c:set var="errorName">
                        <form:errors path="name" cssClass="invalid-feedback"/>
                     </c:set>
                     <c:set var="errorPrice">
                        <form:errors path="price" cssClass="invalid-feedback"/>
                     </c:set>
                     <c:set var="errorDetailDesc">
                        <form:errors path="detailDesc" cssClass="invalid-feedback"/>
                     </c:set>
                     <c:set var="errorShortDesc">
                        <form:errors path="shortDesc" cssClass="invalid-feedback"/>
                     </c:set>
                     <c:set var="errorQuantity">
                        <form:errors path="quantity" cssClass="invalid-feedback"/>
                     </c:set>
                     <!-- end -->
                <div class="mb-3 col-12 col-md-6">
                    <label>Name:</label>
                    <form:input type="text" class="form-control ${not empty errorName ? 'is-invalid' : ''}" path="name"/>
                    ${errorName}
                </div>
                <div class="mb-3 col-12 col-md-6">
                    <label>Price:</label>
                    <form:input type="number" class="form-control ${not empty errorPrice ? 'is-invalid' : ''}" path="price"/>
                    ${errorPrice}
                </div>
                <div class="mb-3 col-12 col-md-6">
                    <label>Detail Description:</label>
                    <form:input type="text" class="form-control ${not empty errorDetailDesc ? 'is-invalid' : ''}" path="detailDesc"/>
                    ${errorDetailDesc}
                </div>
                <div class="mb-3 col-12 col-md-6">
                    <label>Short Description:</label>
                    <form:input type="text" class="form-control ${not empty errorShortDesc ? 'is-invalid' : ''}" path="shortDesc"/>
                    ${errorShortDesc}
                </div>
                <div class="mb-3 col-12 col-md-6">
                    <label>Quantity:</label>
                    <form:input type="number" class="form-control ${not empty errorQuantity ? 'is-invalid' : '' }" path="quantity"/>
                    ${errorQuantity}
                </div>
                <div class="mb-3 col-12 col-md-6">
                    <label class="form-label">Factory:</label>
                    <form:select class="form-select" path="factory">
                        <form:option value="APPLE">Apple (MACBOOK)</form:option>
                        <form:option value="ASUS">Asus</form:option>
                        <form:option value="LENOVO">Lenovo</form:option>
                        <form:option value="DELL">Dell</form:option>
                        <form:option value="LG">LG</form:option>
                        <form:option value="ACER">Acer</form:option>
                    </form:select>
                </div>

                <div class="mb-3 col-12 col-md-6">
                    <label class="form-label">Target:</label>
                    <form:select class="form-select" path="target">
                        <form:option value="GAMING">Gaming</form:option>
                        <form:option value="SINHVIEN-VANPHONG">Sinh Vien - Van Phong</form:option>
                        <form:option value="THIET-KE-DO-HOA">Thiet Ke Do Hoa</form:option>
                        <form:option value="MONG-NHE">Mong Nhe</form:option>
                        <form:option value="DOANH-NHAN">Doanh Nhan</form:option>
                    </form:select>
                </div>
                <div class="mb-3 col-12 col-md-6">
                    <label for="productFile" class="form-label">Image:</label>
                    <input class="form-control" type="file" id="productFile"
                    accept=".png, .jpg , .jpeg" name="ImageFile"
                    >
                </div>
                <div class="col-12 mb-3">
                    <img style="max-height: 250px; display: none;" alt="avatar preview"
                    id="avatarPreview"
                    >
                </div>
                <div class="col-12 mb-5">
                    <button type="submit" class="btn btn-primary">Create</button>
                </div>
            </form:form>
            </div>
        </div>
    </div>
</body>
</html>