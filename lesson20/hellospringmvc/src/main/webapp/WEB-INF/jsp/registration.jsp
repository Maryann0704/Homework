<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="container">
<h2>Register new user</h2>
<br>
<form method="POST" action="${pageContext.request.contextPath}/registration">
  <div class="form-group">
    <label for="firstName">First name</label>
    <input type="text" name="firstName" class="form-control" id="firstName" placeholder="Enter first name">
    <small id="help" class="form-text text-muted">Please enter your name</small>
  </div>
  <div class="form-group">
      <label for="lastName">Last name</label>
      <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Enter second name">
      <small id="help" class="form-text text-muted">Please enter your last name</small>
  </div>
  <div class="form-group">
        <label for="Email">E-mail</label>
        <input type="email" name="Email" class="form-control" id="email" placeholder="Enter your e-mail">
        <small id="help" class="form-text text-muted">Your e-mail will be used for login</small>
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" name="password" class="form-control" id="password" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-primary">Register</button>
</form>
</div>

<jsp:include page="footer.jsp"/>