<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-2 sidebar-right">
	<h3>My Interests</h3>
	<ul class="nav flex-column">

		<c:forEach items="${categoryList}" var="category">
			<li class="nav-item"><a class="nav-link" href="#">${category.name}</a></li>
		</c:forEach>
		<li class="nav-item"><a class="nav-link" href="#"><span
				id="list-category"></span></a></li>

	</ul>
	<input type="text" id="category-text" placeholder="Sports, Events..."
		name="category">
	<button type="button" name="add-category" id="add-category">Add
		Category</button>
</div>