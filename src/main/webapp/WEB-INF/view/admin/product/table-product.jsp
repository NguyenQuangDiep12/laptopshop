<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

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
    <link rel="stylesheet" href="/css/table-user.css">
</head>
<body>
    <div class="container mt-5">
        <div class="row ">
            <div class="col-12 mx-auto mb-2">
                <div class="d-flex justify-content-between">
                    <h3>Table Product</h3>
                <a href="/admin/product/create" class="btn btn-primary d-block">Create New Product</a>            
            </div>
                </div>
            <hr/>

            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Factory</th>
                        <th>Target</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                        
                            <th>${product.id}</th>
                            <th>${product.name}</th>
                            <th>${product.price}</th>
                            <th>${product.detailDesc}</th>
                            <th>${product.shortDesc}</th>
                         
                         <td>
                             <a href="/admin/product/${product.id}" class="btn btn-success">View</a>
                             <a href="/admin/product/update/${product.id}" class="btn btn-warning mx-2">Update</a>
                             <a href="/admin/product/delete/${product.id}" class="btn btn-danger">Delete</a>
                         </td>
                     </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>