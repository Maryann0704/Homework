<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="header.jsp"/>

    <table class="table table-striped table-success">
        <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Name</th>
              <th scope="col">Price</th>
            </tr>
          </thead>
          <tbody>
        <c:forEach var="item" items="${result}">
            <tr>
              <th scope="row">${item.id}</th>
              <td><a href="${pageContext.request.contextPath}/product-catalog/item/${item.id}" class="badge badge-light">${item.itemName}</a></td>
              <td><fmt:formatNumber value="${item.price}" pattern="###.00"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

<jsp:include page="footer.jsp"/>