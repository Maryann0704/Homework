<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="header.jsp"/>

<div class="container">
<form:form method="POST" action="${pageContext.request.contextPath}/add-product" enctype="multipart/form-data" modelAttribute="item">
  <div class="form-group">
    <label for="name">Product name</label>
    <input type="text" name="itemName" class="form-control" id="name" placeholder="Enter product name">
    <small id="emailHelp" class="form-text text-muted">Please describe product item</small>
    <form:errors path="itemName" cssStyle="color: red"/>
  </div>
  <div class="form-group">
    <label for="price">Price</label>
    <input type="number" name="price" class="form-control" id="price" placeholder="Product price">
    <form:errors path="price" cssStyle="color: red"/>
  </div>
  <div class="form-group">
      <label for="File">Picture</label>
      <input type="file" name="file" class="form-control-file" id="File">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>

<jsp:include page="footer.jsp"/>