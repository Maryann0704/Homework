<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="card text-white bg-info mb-3" style="width: 18rem;">
  <img src="${pageContext.request.contextPath}/product-catalog/item/${item.id}/image" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">${item.itemName}</h5>
    <p class="card-text">${item.price} USD</p>
    <a href="#" class="btn btn-warning btn-lg btn-block">Buy</a>
  </div>
</div>

<jsp:include page="footer.jsp"/>