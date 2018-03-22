<!---    
    Autohor : Prakash Rai
    Date    : 208/03/20
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
    <script src="js/wo.js"></script>
</head>

<body>
    <!-- banner div -->
    <div class="jumbotron banner">
        <div class="container">
            <h3 class="banner-icon">Whats out</h3>

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

            <!-- Left side menu -->
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
                        <span class="events-menu-item"></span>Coming Events</span>
                    </li>
                    <li>
                        <i class="glyphicon glyphicon-ok"></i>
                        <span class="events-menu-item"></span>Events Attended</span>
                    </li>
                    <li>
                        <i class="glyphicon glyphicon-thumbs-up"></i>
                        <span class="events-menu-item"></span>Favourite</span>
                    </li>
                </ul>
            </div>
            <!-- col -->

            <!-- Main body content -->
            <div class="col-md-7 main-posts">
                <!-- User profile div -->
                <div class="user-profile">
                    <form method="post" action="UserSetting">
                            <div class="form-group row">
                                <label for="old-password" class="col-sm-3 col-form-label">Old Password</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" name="old-password" placeholder="Old Password">
                                </div>
                            </div>
                            
                        <div class="form-group row">
                            <label for="new-password" class="col-sm-3 col-form-label">New Password</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" name="new-password" placeholder="New Password">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="confirm-password" class="col-sm-3 col-form-label">Confirm Password</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" name="confirm-password" placeholder="Confirm Password">
                            </div>
                        </div>
                        ${errorMsg}
                        <div class="form-group row">
                                <label class="col-sm-3"></label>
                            <div class="offset-sm-3 col-sm-9">
                                <button type="submit" class="btn btn-success save-profile">Change password</button>
                            </div>
                        </div>
                    </form>
                </div><!-- User profile div -->

                <!-- event post -->
            </div>
            <!-- col-md-8 main-posts -->

            <!-- leave one col in right corner -->
            <div class="col-md-1"></div>
        </div>
        <!-- row -->
    </div>
    <!-- container -->
</body>

</html>