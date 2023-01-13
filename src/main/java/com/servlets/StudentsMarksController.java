package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.RegisterBean;
import com.beans.StudentsBean;
import com.beans.SubjectsBean;
import com.dao.OperationsImp;


public class StudentsMarksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public StudentsMarksController() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	doGet(request,response);
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String action = request.getServletPath();
		  
		            switch (action) {
		            
			            case "/StudentSpace":
							try {
								ShowStudentSubjectMarks(request, response);
							} catch (ServletException | IOException | SQLException e4) {
								e4.printStackTrace();
							}
							
							/*************************************/
							
			            case "/SMStudentsList":
			                try {
								SMStudentsMarksOperations(request, response);
							} catch (ServletException | IOException | SQLException e1) {
								e1.printStackTrace();
							}
			                break;
			            case "/SMinsert":
			            	try {
								InsertStudentData(request, response);
							} catch (ServletException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								e.printStackTrace();
							}
			                break;
			            case "/SMedit":
			                try {
								SMshowEditForm(request, response);
							} catch (ServletException | IOException | SQLException e3) {
								e3.printStackTrace();
							}
			                break;
			            case "/updateData":
			                try {
								updateStudentsData(request, response);
							} catch (ServletException | IOException | SQLException e2) {
								e2.printStackTrace();
							}
			                break;
			            case "/delete":
			            	try {
								deleteStudent(request, response);
							} catch (ServletException | IOException | SQLException e2) {
								e2.printStackTrace();
							}
			                break;
			                
			                
			                
			            case "/SMDashbord":
								GoToDashbord(request, response);
			                break;
			            case "/SMTeacherData":
						try {
							GetTeacherData(request, response);
						} catch (ServletException | IOException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                break;
			                
			                
							/*************************************/

			            case "/edit":
			                showEditForm(request, response);
			                break;
			            case "/update":
			            	try {
								updateStudentMark(request, response);
							} catch (ServletException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			                break;
			            case "/search":
			                searchStudent(request, response);
			                break;
			            case "/top10":
			                top10Student(request, response);
			                break;
			            case "/validation":
			                validations(request, response);
			                break;
			            case "/catchingUp":
			            	catchingUp(request, response);
			                break;
			            case "/StudentsMarks":
			            	StudentsMarksOperations(request, response);
			                break;
			                
			            case "/StudentMarks":
							try {
								ShowStudentDataMarks(request, response);
							} catch (ServletException | IOException | SQLException e) {
								e.printStackTrace();
							}
						
			                break;
			                
			            default:
			            	selectAllStudent(request, response);
		            }
		            
	}
	
	
	/*======================================================================*/
	
	 private void ShowStudentSubjectMarks(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException, SQLException {	
		 
			String code=request.getParameter("code");

			OperationsImp metier =new OperationsImp();
			List <StudentsBean> students = metier.getStudentmark(code);
			RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/SView/Students&Marks.jsp");
		 	request.setAttribute("code", code);
		    request.setAttribute("students", students);
		    dispatcher.forward(request, response);  

			
	  }
	 
	/*======================================================================*/
	 
	  private void SMStudentsMarksOperations(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException, SQLException {
		  
		    List<StudentsBean> students =new ArrayList<>();
			OperationsImp metier=new OperationsImp();
			try {
				students = metier.getStudentdata();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    	     request.setAttribute("students", students); 
					 RequestDispatcher dispatcherM=this.getServletContext().getRequestDispatcher("/WEB-INF/SMViews/SMStudentList.jsp");
					 dispatcherM.forward(request, response);
					 
	    }
	  
	
		/*======================================================================*/

	  private void InsertStudentData(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException, SQLException {
		  
		    String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String email=request.getParameter("email");
			int apogee=Integer.parseInt(request.getParameter("apogee"));
			OperationsImp metier =new OperationsImp();
			metier.SMinsertStudent(apogee, firstName, lastName, email);
			List <StudentsBean> students = metier.getStudentdata();
			RequestDispatcher dispatcherM=this.getServletContext().getRequestDispatcher("/WEB-INF/SMViews/SMStudentList.jsp");
			request.setAttribute("students", students);
			dispatcherM.forward(request, response);
	  }
	  
		/*======================================================================*/
      
      private void SMshowEditForm(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException, SQLException {
      	
        	int apogee =Integer.parseInt(request.getParameter("apogee"));
			OperationsImp metier=new OperationsImp();
        	StudentsBean student=metier.getStudentsByApogee(apogee);
        	ServletContext context = this.getServletContext();
		    context.setAttribute("apogee", apogee);
			RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/SMViews/UpdateStudent.jsp");
		    request.setAttribute("student", student);
			request.setAttribute("apogee", apogee);
			dispatcher.forward(request, response);
			
			}
	  
	  	/*======================================================================*/

		  private void updateStudentsData(HttpServletRequest request, HttpServletResponse response)
	              throws ServletException, IOException, SQLException {
				  
			    StudentsBean student=new StudentsBean();
			    OperationsImp metier=new OperationsImp();
			    ServletContext context = this.getServletContext();
		        int apogee = (int)context.getAttribute("apogee");
				
				String firstName=request.getParameter("firstName");
				String lastName=request.getParameter("lastName");
				String email =request.getParameter("email");
				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setEmail(email);
				
				metier.updateStudentData(apogee,student);
				List<StudentsBean> students=metier.getStudentdata();					
				request.setAttribute("students", students); 
				RequestDispatcher dispatcherM=this.getServletContext().getRequestDispatcher("/WEB-INF/SMViews/SMStudentList.jsp");
				dispatcherM.forward(request, response);
						 
		    }
	        
		    	/*======================================================================*/

		        private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
		                throws ServletException, IOException, SQLException {
		        	
		        	int apogee =Integer.parseInt(request.getParameter("apogee"));
		    		OperationsImp metier1=new OperationsImp();
		    		try {
		    			metier1.deleteStudent(apogee);
		    		} catch (SQLException e) {
		    			// TODO Auto-generated catch block
		    			e.printStackTrace();
		    		}
		    		OperationsImp metier2=new OperationsImp();
		    		List <StudentsBean> students = metier2.getStudentdata();
					RequestDispatcher dispatcherM=this.getServletContext().getRequestDispatcher("/WEB-INF/SMViews/SMStudentList.jsp");
					request.setAttribute("students", students);
					dispatcherM.forward(request, response);
		     
		        }
		        

		    	/*======================================================================*/
		        
		        
		        private void GoToDashbord(HttpServletRequest request, HttpServletResponse response)
		                throws ServletException, IOException{
					OperationsImp metier =new OperationsImp();


					RequestDispatcher dispatcher;
					try {						
						int StudentCounter=metier.StudentsNumer();
						int TeacherCounter=metier.TeacherNumber();
						double jeeFisrtMark=metier.jeeFirstMark();
						double jeeLastMark=metier.jeeLaststMark();
						double frameworksFirstMark=metier.frameworksFirstMark();
						double frameworksLastMark=metier.frameworksLaststMark();
						double csFirstMark=metier.csFirstMark();
						double csLastMark=metier.csLaststMark();
						
						dispatcher=request.getRequestDispatcher("/WEB-INF/SMViews/Home.jsp");
						
						request.setAttribute("StudentCounter", StudentCounter);
						request.setAttribute("TeacherCounter", TeacherCounter);
						request.setAttribute("jeeFisrtMark", jeeFisrtMark);
						request.setAttribute("jeeLastMark", jeeLastMark);
						request.setAttribute("frameworksFirstMark", frameworksFirstMark);
						request.setAttribute("frameworksLastMark", frameworksLastMark);
						request.setAttribute("csFirstMark", csFirstMark);
						request.setAttribute("csLastMark", csLastMark);
						
						dispatcher.forward(request, response);
					





						dispatcher.forward(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		        }
		        /*======================================================================*/
		        private void GetTeacherData(HttpServletRequest request, HttpServletResponse response)
		                throws ServletException, IOException, SQLException {
		        	
		        	OperationsImp metier=new OperationsImp();
		        	List <RegisterBean> teachers=metier.getTeacherData();
		        	RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/SMViews/TeacherList.jsp");
					request.setAttribute("teachers", teachers);
					dispatcher.forward(request, response);

		        }
		        
		        
		        /*======================================================================*/

		        
		        private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		                throws ServletException, IOException {
		        	
		          	int apogee =Integer.parseInt(request.getParameter("apogee"));
		        	 OperationsImp metier=new OperationsImp();
					String code="";
					ServletContext context = this.getServletContext();
					String subject = (String)context.getAttribute("subject");
		    		StudentsBean student =new StudentsBean();				
					switch(subject) {
					case "jee":
						code="jee_code";
						RequestDispatcher dispatcherj=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/UpdateStudent.jsp");
						request.setAttribute("code", code);

		    			try {
							student=metier.getStudentsByApogee(apogee,code);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			request.setAttribute("student", student);
						 dispatcherj.forward(request, response);
						break;
						
						
						
					case "framworks":
						code="framworks_code";
						RequestDispatcher dispatcherf=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/UpdateStudent.jsp");
						request.setAttribute("code", code);

		    			try {
							student=metier.getStudentsByApogee(apogee,code);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			request.setAttribute("student", student);
						 dispatcherf.forward(request, response);
						break;
					case "maths":
						code="maths_code";
						RequestDispatcher dispatcherm=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/UpdateStudent.jsp");
						request.setAttribute("code", code);

		    			try {
							student=metier.getStudentsByApogee(apogee,code);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			request.setAttribute("student", student);
						 dispatcherm.forward(request, response);
						break;

					case "mobile_dev":
						code="dev_mobile_code";
						RequestDispatcher dispatcherd=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/UpdateStudent.jsp");
						request.setAttribute("code", code);

		    			try {
							student=metier.getStudentsByApogee(apogee,code);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			request.setAttribute("student", student);
		    			dispatcherd.forward(request, response);
						break;
					case "c#":
						code="cs_code";
						RequestDispatcher dispatcherc=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/UpdateStudent.jsp");
						request.setAttribute("code", code);

		    			try {
							student=metier.getStudentsByApogee(apogee,code);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			request.setAttribute("student", student);
						 dispatcherc.forward(request, response);
					break;
					case "administration_system":
						code="administration_system_code";
						RequestDispatcher dispatchera=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/UpdateStudent.jsp");
						request.setAttribute("code", code);

		    			try {
							student=metier.getStudentsByApogee(apogee,code);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			request.setAttribute("student", student);
						dispatchera.forward(request, response);
					}
					

		        }
		        
		    	/*======================================================================*/

		     
		        private void updateStudentMark(HttpServletRequest request, HttpServletResponse response)
		                throws ServletException, IOException, SQLException {
		        	
		        	 OperationsImp metier=new OperationsImp();
					ServletContext context = this.getServletContext();
					String subject = (String)context.getAttribute("subject");
		    		StudentsBean student =new StudentsBean();
		    		int apogee=Integer.parseInt(request.getParameter("apogee"));
					String code="";	
					double mark=Double.parseDouble(request.getParameter("mark"));
					switch(subject) {
					
					case "jee":
						code="jee_code";
						student.setJee_mark(mark);
						metier.updateStudentMark(student,apogee,code);
			    		response.sendRedirect("StudentsMarks"); 
					break;
					
					case "framworks":
						code="framworks_code";
						student.setFrameworks_mark(mark);
						metier.updateStudentMark(student,apogee,code);
			    		response.sendRedirect("StudentsMarks"); 
					break;
					
					case "maths":
						code="maths_code";
						student.setMaths_mark(mark);
						metier.updateStudentMark(student,apogee,code);
			    		response.sendRedirect("StudentsMarks"); 
					break;
					
					case "mobile_dev":
						code="dev_mobile_code";
						student.setMobile_dev_mark(mark);
						metier.updateStudentMark(student,apogee,code);
			    		response.sendRedirect("StudentsMarks"); 
					break;
					
					case "c#":
						code="cs_code";
						student.setCs_mark(mark);
						metier.updateStudentMark(student,apogee,code);
			    		response.sendRedirect("StudentsMarks"); 
					break;
					
					case "administration_system":
						code="administration_system_code";
						student.setAdministration_system_mark(mark);
						metier.updateStudentMark(student,apogee,code);
			    		response.sendRedirect("StudentsMarks"); 
					}
					
	    			 		
	 
		        }
		        
		        
		        /*======================================================================*/
		        
		        private void searchStudent(HttpServletRequest request, HttpServletResponse response)
		                throws ServletException, IOException {
		        	
		        	 try {
		        		 
		        		   String firstName=request.getParameter("firstName");
					        OperationsImp metier=new OperationsImp();
					        List <StudentsBean> students=metier.getStudentByfirstName(firstName);
				    		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/StudentList.jsp");
			    			request.setAttribute("students", students);
							 dispatcher.forward(request, response);
						} 
		        	 catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        	
		        }
		        /*======================================================================*/

		        
		        private void top10Student(HttpServletRequest request, HttpServletResponse response)
		                throws ServletException, IOException {
		        	
		        	 try {
		        		 
				        	
					        OperationsImp metier=new OperationsImp();
					        String code="";
					        ServletContext context = this.getServletContext();
					        String subject = (String)context.getAttribute("subject");
					        
					        switch(subject) {
					        case "jee":
					        	code="jee_code";
					        	break;
					        case "framworks":
					        	code="framworks_code";
					        	break;
					        case "maths":
					        	code="maths_code";
					        	break;
					        case "mobile_dev":
					        	code="dev_mobile_code";
					        break;
					        case "c#":
					        	code="cs_code";
					        break;
					        case "administration_system":
					        	code="administration_system_code";
					        }
					        
					        List <StudentsBean> students =metier.getTop10Student(code);
					        
					        
				    		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Students&Marks.jsp");
			    			request.setAttribute("students", students);
			    			request.setAttribute("code", code);
			    			request.setAttribute("subject", subject);

							 dispatcher.forward(request, response);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        	
		        }
		        
		    	/*======================================================================*/

		        
		        private void validations(HttpServletRequest request, HttpServletResponse response)
		                throws ServletException, IOException {
		        	
		        	
		        	 try {
		        		 
				        	
					        OperationsImp metier=new OperationsImp();
					        String code="";
					        ServletContext context = this.getServletContext();
					        String subject = (String)context.getAttribute("subject");
					        
					        switch(subject) {
					        case "jee":
					        	code="jee_code";
					        	break;
					        case "framworks":
					        	code="framworks_code";
					        	break;
					        case "maths":
					        	code="maths_code";
					        	break;
					        case "mobile_dev":
					        	code="dev_mobile_code";
					        break;
					        case "c#":
					        	code="cs_code";
					        break;
					        case "administration_system":
					        	code="administration_system_code";
					        }
					        
					        List <StudentsBean> students =metier.getValidations(code);
					        
					        
				    		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Students&Marks.jsp");
			    			request.setAttribute("students", students);
			    			request.setAttribute("code", code);
			    			request.setAttribute("subject", subject);

							 dispatcher.forward(request, response);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        	
		        }
		        
		  
		        
		    	/*======================================================================*/		        
		        private void catchingUp(HttpServletRequest request, HttpServletResponse response)
		                throws ServletException, IOException {
		        	
		        	
		        	 try {
		        		 
				        	
					        OperationsImp metier=new OperationsImp();
					        String code="";
					        ServletContext context = this.getServletContext();
					        String subject = (String)context.getAttribute("subject");
					        
					        switch(subject) {
					        case "jee":
					        	code="jee_code";
					        	break;
					        case "framworks":
					        	code="framworks_code";
					        	break;
					        case "maths":
					        	code="maths_code";
					        	break;
					        case "mobile_dev":
					        	code="dev_mobile_code";
					        break;
					        case "c#":
					        	code="cs_code";
					        break;
					        case "administration_system":
					        	code="administration_system_code";
					        }
					        
					        List <StudentsBean> students =metier.getCatchingUp(code);
					        
					        
				    		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Students&Marks.jsp");
			    			request.setAttribute("students", students);
			    			request.setAttribute("code", code);
			    			request.setAttribute("subject", subject);

							 dispatcher.forward(request, response);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        	
		        }
		    	/*======================================================================*/

		        
		        private void StudentsMarksOperations(HttpServletRequest request, HttpServletResponse response)
		                throws ServletException, IOException {
		        	
		       	 try {
	        		 
			        	
				        OperationsImp metier=new OperationsImp();
				        String code="";
				        ServletContext context = this.getServletContext();
				        String subject = (String)context.getAttribute("subject");
				        
				        switch(subject) {
				        case "jee":
				        	code="jee_code";
				        	break;
				        case "framworks":
				        	code="framworks_code";
				        	break;
				        case "maths":
				        	code="maths_code";
				        	break;
				        case "mobile_dev":
				        	code="dev_mobile_code";
				        break;
				        case "c#":
				        	code="cs_code";
				        break;
				        case "administration_system":
				        	code="administration_system_code";
				        }
				        
				        List <StudentsBean> students =metier.getStudentmark(code);
				        
				        
			    		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/StudentsMarks.jsp");
		    			request.setAttribute("students", students);
		    			request.setAttribute("code", code);
		    			request.setAttribute("subject", subject);

						 dispatcher.forward(request, response);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	     	
	        }

		    	/*======================================================================*/
	  
	    private void ShowStudentDataMarks(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException, SQLException {
		  
			OperationsImp metier =new OperationsImp();
			List <StudentsBean> students = metier.SMgetStudentsMarks();
			 RequestDispatcher dispatcherM=this.getServletContext().getRequestDispatcher("/WEB-INF/SMViews/Students&Marks.jsp");
			 request.setAttribute("students", students);
			 dispatcherM.forward(request, response);
	    }

	    	/*======================================================================*/
	    				 
	        private void selectAllStudent(HttpServletRequest request, HttpServletResponse response)
	                throws ServletException, IOException {
	        	
	        	List<StudentsBean> students =new ArrayList<>();
	    		OperationsImp metier=new OperationsImp();
	    		try {
	    			students = metier.getStudentdata();
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		
	    	    	    request.setAttribute("students", students); 
	    				 RequestDispatcher dispatcherM=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/StudentList.jsp");
	    				 dispatcherM.forward(request, response);
	    				 
	        }
	            
	}