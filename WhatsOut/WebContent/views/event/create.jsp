<!---    
    Autohor : Prakash Rai
    Date    : 208/03/20
    Contact : prakashrainpl@gmail.com
    Description : Main Layout page for the home page
-->

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>What's Out</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- Font awsome css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />

    <!-- Reset default browser CSS -->
    <link rel="stylesheet" href="css/default.css">

    <!-- Custom Login CSS -->
    <link rel="stylesheet" href="css/style.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- main.js -->
    <script src="js/event.js"></script>
</head>

<body>

    <!-- banner div -->
    <div class="jumbotron banner">
        <div class="container">
            <h3 class="banner-icon">Create Event - aWhats out</h3>

            <div class="dropdown user-profile-dropdown">
                <img src="images/user.jpg" class="user-profile-dropdown dropdown-toggle" id="user-profile-dropdown" data-toggle="dropdown"
                />

                <ul class="dropdown-menu" aria-labelled-by="user-profile-dropdown">
                    <li>
                        <a>My Profile</a>
                    </li>
                    <li>
                        <a>Settings</a>
                    </li>
                    <li>
                        <a>Logout</a>
                    </li>

                </ul>
            </div>

        </div>
        <!-- container -->
    </div>
    <!-- jumbotron -->

    <!-- main body div -->
    <div class="container-fluid main-body">
        <div class="row">
            <!-- leave one col in left corner -->
            <div class="col-md-1"></div>
            <!-- left side bar -->
            <div class="col-md-2 sidebar-left">
                <div class="input-group">
                    <input class="form-control" placeholder="Search...">
                    <div class="input-group-addon">
                        <i class="fa fa-search"></i>
                    </div>
                </div>

                <br/>
                <br/>
                <ul class="events-menu ">
                    <li>
                        <i class="glyphicon glyphicon-user"></i>
                        <span class="events-menu-item">My Events</span>
                    </li>
                    <li>
                        <i class="glyphicon glyphicon-hand-up"></i>
                        <span class="events-menu-item"></span>Coming Events
                    </li>
                    <li>
                        <i class="glyphicon glyphicon-ok"></i>
                        <span class="events-menu-item"></span>Events Attended
                    </li>
                    <li>
                        <i class="glyphicon glyphicon-thumbs-up"></i>
                        <span class="events-menu-item"></span>Favourite
                    </li>
                </ul>
            </div>
            <!-- col -->

            <div class="col-md-6 main-posts">
                <div class="event-post">
                    <div class="panel panel-success panel-posts">
                        <div class="panel-heading">
                            <h1 class="panel-title">Create a new Event!!</h1>
                        </div>
                        <!-- panel heading -->

                        <div class="panel-body">
                            <form id="new-event">
                                <div class="form-group row">
                                    <label class="col-sm-3 event-picture-label">Event logo</label>
                                    <div class="col-sm-9">
                                        <input type="file" name="" id="event-picture" />
                                        <img src="images/event.png" alt="event picture" class="upload-event-picture" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="title" class="col-sm-3 col-form-label">Title</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="title" placeholder="Title">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="location" class="col-sm-3 col-form-label">Location</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="location" placeholder="Location">
                                    </div>
                                </div>

                                <div class="form-group row">
                                        <label for="description" class="col-sm-3 col-form-label">Description</label>
                                        <div class="col-sm-9">
                                            <textarea class="form-control" rows="5"  id="description"></textarea>
                                        </div>
                                    </div>

                                <div class="form-group row">
                                    <label for="date" class="col-sm-3 col-form-label">Date</label>
                                    <div class="col-sm-9">
                                        <input type="date" class="form-control" id="date" placeholder="Date">
                                    </div>
                                </div>

                                <div class="form-group row">
                                        <label for="time" class="col-sm-3 col-form-label">Time</label>
                                        <div class="col-sm-9">
                                            <input type="time" class="form-control" id="time" placeholder="Time">
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                            <label for="capacity" class="col-sm-3 col-form-label">Capacity</label>
                                            <div class="col-sm-9">
                                                <input type="number" class="form-control" id="capacity" placeholder="Capacity">
                                            </div>
                                        </div>
        

                                <div class="form-group row">
                                    <label class="col-sm-3">Categories</label>
                                    <div class="col-sm-9">
                                        <div class="form-check">
                                            <label class="form-check-label">
                                                <input class="form-check-input" type="checkbox"> Sports
                                                <input class="form-check-input" type="checkbox"> Music
                                                <input class="form-check-input" type="checkbox"> Arts
                                                <input class="form-check-input" type="checkbox"> Dance
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3"></label>
                                    <div class="offset-sm-3 col-sm-9">
                                        <button type="submit" class="btn btn-success save-profile">Save changes</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- panel-body -->

                    </div>
                    <!-- panel -->


                </div>
                <!-- event post -->
            </div>
            <!-- col-md-6 main-posts -->

            <!-- Right side bar -->
            <div class="col-md-2 sidebar-right">
                <h3>My Interests</h3>
                <ul class="nav flex-column">

                    <li class="nav-item">
                        <a class="nav-link" href="#">Sports</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Music</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Photography</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Football</a>
                    </li>
                </ul>
            </div>
            <!-- col -->

            <!-- leave one col in right corner -->
            <div class="col-md-1"></div>
        </div>
        <!-- row -->
    </div>
    <!-- container -->
</body>

</html>