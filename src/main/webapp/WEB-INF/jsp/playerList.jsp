<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Player List</title>
</head>
<body>
<h1>Player List</h1>
<a href="addPlayer.jsp">Add New Player</a>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Full Name</th>
        <th>Age</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="player" items="${players}">
        <tr>
            <td>${player.name}</td>
            <td>${player.fullName}</td>
            <td>${player.age}</td>
            <td>
                <a href="editPlayer.jsp?id=${player.playerId}">Edit</a>
                <a href="deletePlayer?id=${player.playerId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
