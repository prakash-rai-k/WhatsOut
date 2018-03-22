<!---    
    Autohor : Prakash Rai
    Date    : 208/03/20
    Contact : prakashrainpl@gmail.com
    Description : Right-side menu
-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-2 sidebar-right">
	<h3>My Interests</h3>
	<ul class="nav flex-column" id="my-categories">
		<c:forEach items="${categoryList}" var="subscription">
			<li class="nav-item"><a class="nav-link" href="#">${subscription.name}</a></li>
		</c:forEach>
	</ul>
	<hr/>
	<input type="text"  class="form-control suggest-category" id="category-text" placeholder="Sports, Events..." name="category">
	<textarea class="form-control suggest-category" rows="3" id="category-description" placeholder="Description" name="description" id="text-area-description"></textarea>
	<button type="button" class="btn btn-success suggest-category" name="add-category" id="add-category">Suggest</button>
</div>