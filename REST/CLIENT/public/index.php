<?php
// Autoloader
require_once __DIR__ . '/../vendor/autoload.php';
require_once __DIR__ . '/../autoload.php';

use models\User;

// Obtengo todos los usuarios
$users = User::getAll();

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cliente REST | Home</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.css">

    <!-- JS -->
    <script defer type="module" src="/js/app.js"></script>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="#">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-end" id="navbarColor01">
                <form class="d-flex">
                    <input class="form-control me-sm-2" type="text" placeholder="Search a user">
                </form>
            </div>
        </div>
    </nav>
    <main class="mt-5 container-fluid">
        <section class="row">
            <article class="col-4">
                <form id="form-user" class="card">
                    <div class="card-body">
                        <p id="title-form" class="h3 text-center">Insert a User</p>
                        <div class="mb-3">
                            <input type="text" class="form-control" placeholder="Name" name="Name">
                        </div>
                        <div class="mb-3">
                            <input type="email" class="form-control" placeholder="Email" name="Email">
                        </div>
                        <div class="mb-3">
                            <input type="password" class="form-control" placeholder="Password" name="Password">
                        </div>
                        <div class="mb-3">
                            <textarea name="Description" class="form-control" rows="5" placeholder="Description"></textarea>
                        </div>
                        <button class="btn btn-primary w-100" type="submit">Save</button>
                    </div>
                </form>
            </article>
            <article class="col-8">
                <table class="table table-active table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Description</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody id="users">
                        <?php foreach ($users as $user) : ?>
                            <tr _id="<?= $user->id ?>">
                                <td><?= $user->id ?></td>
                                <td><?= $user->Name ?></td>
                                <td><?= $user->Email ?></td>
                                <td><?= $user->Description ?></td>
                                <td>
                                    <div class="row">
                                        <div class="col">
                                            <button class="btn btn-info w-100">Edit</button>
                                        </div>
                                        <div class="col">
                                            <button class="btn btn-danger w-100">Delete</button>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        <?php endforeach; ?>
                    </tbody>
                </table>
            </article>
        </section>
    </main>
</body>

</html>