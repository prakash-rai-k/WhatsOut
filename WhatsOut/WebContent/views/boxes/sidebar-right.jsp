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
	
	<hr/>
	<input type="text" class="form-control suggest-category" id="category-text"
		placeholder="Category" name="category">
	<textarea class="form-control suggest-category" rows="3" id="category-description"
		placeholder="Description" name="description"></textarea>
	<button type="button" class="btn btn-success suggest-category" name="add-category"
		id="add-category">Suggest</button>
</div>