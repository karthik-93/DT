<body style="background-color:#DFF6F1;">
<div class="container">
    <div class="row">
    <div class="col-lg-4">
                         
     </div>
     <div class="column-lg-8">
    <h1 style="color:black" font-weight:100%;><strong>SHOPPING CART</strong></h1>
     </div>
        <!-- navbar-->
        <nav>
        <div style="margin-top:40px";>
        <a href="listig" class="btn btn-primary">
          <span class="glyphicon glyphicon-home"></span> Home
        </a>&nbsp;
        <a href="#" class="btn btn-primary">
          <span class="glyphicon glyphicon-search"></span> Search 
        </a>&nbsp;
        <c:if test="${pageContext.request.userPrincipal.name== null}">
        <a href="login" class="btn btn-primary">
          <span class="glyphicon glyphicon-log-in"></span> Sign in
        </a>&nbsp;</c:if>
        
        <c:if test="${pageContext.request.userPrincipal.name== null}">
        <a href="#" class="btn btn-primary">
          <span class="glyphicon glyphicon-log-out"></span> Sign up
         </a>&nbsp;</c:if>
        
        <c:if test="${pageContext.request.userPrincipal.name!= null}">
        <a href="javascript:formSubmit()" class="btn btn-primary">
          <span class="glyphicon glyphicon-log-out"></span> Sign out
        </a>&nbsp;</c:if>
        
        <c:if test="${pageContext.request.userPrincipal.name!= null}">
         <a href="totablecart" class="btn btn-primary">
          <span class="glyphicon glyphicon-shopping-cart"></span> Cart</a>
        <a href="#" class="btn btn-link"><span ></span>Hi :${pageContext.request.userPrincipal.name}
        </a>
        </c:if>
        <!-- ========================= -->
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
        <!-- ========================= -->
      </p> 
                   
                </ul>
               
            </div>
       </nav>
<!--- nav ends-->
</div>
</div>
</body>
