<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">

  <body>
    <br><br>

    <form:form action="new" method="post" modelAttribute="newStudent">
                <form:label path="name">Name</form:label>
                <form:input path="name" type="text"/>
                <form:label path="age">Age</form:label>
                <form:input path="age" type="number"/>
        <form:button type="submit">Save</form:button>
    </form:form>
    <br><br>

    <div>
      <table border="1">
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Age</th>
        </tr>
        <c:forEach  items="${students}" var ="student">
        <form:form id="student${student.id}" method="post" modelAttribute="updateStudent">
        <tr>
          <td><form:input path="id" value="${student.id}" type="number"/></td>
          <td><form:input path="name" value="${student.name}" type="text" formaction="updateName"/></td>
          <td><form:input path="age" value="${student.age}" type="number" formaction="updateAge"/></td>
          </form:form>
          <td><button type="submit" formaction="update" form="student${student.id}">Update</button>
              <button type="submit" formaction="delete" form="student${student.id}">Delete</button></td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </body>