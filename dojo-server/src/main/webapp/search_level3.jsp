<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Search form</title>
	    <script type='text/javascript'>
	        function setAction(name) {
                var input = document.getElementById('action');
                input.value = name;
            }
        </script>
	</head>
	<body>
        <form name="search" method="post" action="${context}">
            <input type="hidden" name="action" id="action" value="search"/>
			<jsp:include page="search_box.jsp"/>

            <c:if test="${requestScope.records != null}">
                <span id="search_info">
                    <c:choose>
                        <c:when test="${requestScope.no_results}">
                            Sorry no results for your request, but we have another devices:
                        </c:when>
                        <c:otherwise>
                            List:
                        </c:otherwise>
                    </c:choose>
                </span></br>
                <table id="product_list">
                    <tr>
                        <td></td>
                        <td>Description</td>
                        <td>Price
                            <jsp:include page="sorting_order.jsp"/>
                        </td>
                    </tr>
                    <c:forEach items="${requestScope.records}" var="record" varStatus="status">
                        <tr id="productId_${record.id}">
                            <td id="select_checkbox">
                                <input type="checkbox" value="${record.id}"
                                       name="record" id="record_${status.index+1}">
                            </td>
                            <td id="element_description">'${record.description}'</td>
                            <td id="element_price">${record.price}$</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><input type="submit" value="Add to Cart" id="add_to_cart_button" onClick="setAction('cart');"></td>
                    </tr>
                </table>
            </form>
        </c:if>
	</body>
</html>