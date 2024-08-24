<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Delete</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
  integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
  integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" 
  integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" 
  crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</head>
<body>
   <div class="container pt-5">
    <div class="pb-5">
      <h1>Confirm delete of user id ${id}</h1>
    </div>
    <form:form action="/admin/user/delete" method="post" modelAttribute="newUser">
      <div class="form-group" style="display: none">
        <label for="exampleInputEmail1">Id:</label>
        <form:input type="text" value="${id}"  class="form-control" path="id"/>	
      </div>
      <hr>
      <div class="form-group">
        <label for="exampleInputPassword1">Email</label>
        <form:input type="email" class="form-control" path="email"   disabled="true"/>
      </div>
      <hr>
      <div class="form-group">
          <label for="exampleInputPassword1">Phone Number:</label>
          <form:input type="tel" class="form-control" path="phone" placeholder="Phone" disabled="true"/>
        </div>
      <hr>
      <div class="form-group">
        <label for="exampleInputPassword1">Full Name:</label>
        <form:input type="text" class="form-control" path="fullName" placeholder="Full name" disabled="true"/>
      </div>
      <button type="submit" class="btn btn-primary mt-5">Submit</button>
    </form:form>
   </div>
</body>
</html>