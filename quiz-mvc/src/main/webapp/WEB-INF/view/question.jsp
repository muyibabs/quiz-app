<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Question</title>

    <link rel="stylesheet" href="css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
    <script src="js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>
<body>

    <div class="container">
      <h4>Question ${currentQuestion}.</h4>
      <form:form action="/save-answer" modelAttribute="answer">
        <div class="form-group">
          <label for="question">${quiz.question}</label>
            <br/><form:errors path="answer" style="color:red;" />
          <div class="radio">
            <label><form:radiobutton path="answer" value="1"/>${quiz.option1}</label>
          </div>
          <div class="radio">
            <label><form:radiobutton path="answer" value="2"/>${quiz.option2}</label>
          </div>
          <div class="radio">
            <label><form:radiobutton path="answer" value="3"/>${quiz.option3}</label>
          </div>
          <div class="radio">
            <label><form:radiobutton path="answer" value="4"/>${quiz.option4}</label>
          </div>

        </div>

        <button type="submit" class="btn btn-default">Submit</button>
      </form:form>
    </div>

</body>
</html>