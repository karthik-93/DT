<%@ page language="java" contentType="text/html"%>

<%@include file="header.jsp" %>
  
<form action="perform_login" method="post">  
<div class="container">
	<div class="row main">
		<div class="main-login main-center">
			<h5> LOGIN </h5>
	
  
 <div class="form-group">
					  <label for="username" class="cols-sm-2 control-label">Username</label>
						<div class="cols-sm-10">
							<div class="input-group">
							   <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
							   <input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username"/>
							</div>
						</div>
					</div>
 <div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
								</div>
							</div>
					</div>
  
  
    <td colspan="2"> <center><input type="submit" class="btn btn-primary btn-lg btn-block login-button" value="LOGIN"/></center> </td>
  </tr>
     
     </div>
     </div>
     </div>
    
</form>

  