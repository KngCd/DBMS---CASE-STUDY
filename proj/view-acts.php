<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/style4.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <title>Task Mastery</title>
</head>
<body>

  <div class="header">
        <div class="left-side">
          <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a class="link" href="THome.php"><i class="fa-solid fa-house"></i>Home</a>
            <a class="link" href="#"><i class="fa-solid fa-calendar"></i>Calendar</a>
            <button class="dropdown-btn">
              <i class="fa-solid fa-graduation-cap"></i>
              <span>Class<i class="fa fa-caret-down"></i></span>
            </button>
            <div class="dropdown-container">
            <?php 
                  session_start();
                  include('config.php');

                  $id = $_SESSION['id'];
                  $classcode = $_POST['classcode'];
      
                  // Fetch the classes created by the teacher from the database
                  $query = mysqli_query($con, "SELECT subject FROM class WHERE teacher_id = '$id' AND classcode = '$classcode'");
                  
                  $result = mysqli_num_rows($query);
                  $row = mysqli_fetch_assoc($query);
          
                  if (isset($row)) {
                    echo '<a class="link2" href="#"><i class="fa fa-circle fa-fw"></i>' . $row['subject'] . '</a>';
                  }
                  ?>
                </div>
                <button class="dropdown-btn">
                  <i class="fa-regular fa-square-plus"></i>
                  <span>Add<i class="fa fa-caret-down"></i></span>
                </button>
                <div class="dropdown-container">
                  <a class="link2" href="upload_module.php"><i class="fa fa-circle fa-fw"></i>Module</a>
                  <a class="link2" href="upload_act.php"><i class="fa fa-circle fa-fw"></i>Activity</a>
                  <a class="link2" href="upload_ann.php"><i class="fa fa-circle fa-fw"></i>Announcement</a>
                </div>
            <a class="link" href="#"><i class="fa-solid fa-gear"></i>Settings</a><br><br><br><br>
            <a class="link" href="LoginSignup.php"><i class="fa-solid fa-right-from-bracket"></i>LOGOUT</a>
          </div>

          <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
          <i  id="school-icon" class="fa-solid fa-book-open"></i>
          <a class="tm" href="THome.php"><p>Task Mastery</p> </a> <i class="fa-solid fa-greater-than"></i>
          <?php
             $id = $_SESSION['id'];
             $classcode = isset($_POST['classcode']) ? mysqli_real_escape_string($con, $_POST['classcode']) : '';

             $query = mysqli_query($con, "SELECT subject FROM class WHERE teacher_id = '$id' AND classcode = '$classcode'");
             $result = mysqli_num_rows($query);
             $row = mysqli_fetch_assoc($query);
     
             if (isset($row)) {
               echo '<div class="sub">' . $row['subject'] . '</div>';
             }

          ?>
            </div>
          <script>
            function openNav() {
            document.getElementById("mySidenav").style.width = "250px";
            document.getElementById("main").style.marginLeft = "250px";
            }

            function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
            document.getElementById("main").style.marginLeft= "0";
            }

          </script>
          <script>
          /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
          var dropdown = document.getElementsByClassName("dropdown-btn");
          var i;

          for (i = 0; i < dropdown.length; i++) {
            dropdown[i].addEventListener("click", function() {
              this.classList.toggle("active");
              var dropdownContent = this.nextElementSibling;
              if (dropdownContent.style.display === "block") {
                dropdownContent.style.display = "none";
              } else {
                dropdownContent.style.display = "block";
              }
            });
          }
          </script>

    <div class="right-side">
      <button onclick="location.href='create-subject.php'">
            <i class="fa-solid fa-plus"></i>
      </button>
      <button onclick="location.href='Tedit.php'">
            <i class="fa-solid fa-user"></i>
        </button>
      </div>
    </div>

<div class="main-body">
    <div class="body-section2" id="main">
    <?php
        include('config.php');

        $id = $_SESSION['id'];
        $classcode = $_POST['classcode'];
        $act_id = $_POST['act_id'];

        // Query the activity table for the row with the matching act_id
        $query = mysqli_query($con, "SELECT c.subject, c.classcode, c.teacher_id, ac.act_id, 
        ac.topic, ac.classcode, ac.teacher_id FROM class c JOIN activity ac ON c.classcode = ac.classcode 
        WHERE ac.act_id = '$act_id' AND c.teacher_id = '$id'");
        $result = mysqli_num_rows($query);
        $row = mysqli_fetch_assoc($query);

        if (isset($row)) {
            echo '<div class="mod-container">';
            echo '<label class="label">Activity ID : '. '<b>'. $row['act_id'] . '</b>' . '</label>';
            echo '<label class="label">Activity Name : '. '<b>' . $row['topic'] . '</b>' .'</label>';
            echo '<label class="label">Classcode : '. '<b>' . $row['classcode'] . '</b>' .'</label>';
            echo '</div>';
        } else {
            echo "No activity found with that ID.";
        }                        

    ?>

    </div>
</div>
