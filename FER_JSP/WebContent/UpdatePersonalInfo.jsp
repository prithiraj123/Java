
<%@page import="com.rs.fer.bean.PersonalInfo"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	FERService service = new FERServiceImpl();
	PersonalInfo personalinfo = (PersonalInfo) session.getAttribute("personalinfo");

	boolean updateFlag = service.updatePersonalInfo(personalinfo.getUser(), personalinfo.getAddress());
%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
	if (updateFlag) {
		out.println("Update Successfully");
	} else {
		out.println("Unable To Update");
	}
%>
<jsp:include page="Footer.jsp" />
