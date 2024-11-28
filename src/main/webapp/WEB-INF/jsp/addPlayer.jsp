<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Player</title>
</head>
<body>
<h1>Add Player</h1>
<form action="players" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="full_name">Full Name:</label>
    <input type="text" id="full_name" name="full_name" required><br>

    <label for="age">Age:</label>
    <input type="text" id="age" name="age" required><br>

    <label for="index_id">Index ID:</label>
    <input type="number" id="index_id" name="index_id" required><br>

    <button type="submit">Add Player</button>
</form>
<a href="players">Back to Player List</a>
</body>
</html>
