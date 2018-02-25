<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>I'm having a party and You're invited!</h1>
        <p>
            Can you attend? 
        </p>
        <form action="RSVPController" method="POST">
            <input type="text" name="answer"/> <br>
            <select name="reason">
                <option value="out of town">I'm going to be out of town.</option>
                <option value="schedule Conflict">I have  a previous engagement </option>
                <option value="don't like you"> I don't like you </option>
                
            </select>
            <break>
            <input type="submit" value="RSVP"/>
            
        </form>
    </body>
</html>
  