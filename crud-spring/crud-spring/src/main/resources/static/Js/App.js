function updateStudent(id, name, email, password) {
    document.getElementById("modalUpdateForm").action = "/student/update/" + id;
    document.getElementById("modalUpdateInputName").value = name;
    document.getElementById("modalUpdateInputEmail").value = email;
    document.getElementById("modalUpdateInputpassword").value = password;
  }
  
  
  function updateProfessor(id,name,email,curricularUnit){
    document.getElementById("modalUpdateFormProfessor").action = "/teachers/update/" + id;
    document.getElementById("modalUpdateInputName").value = name;
    document.getElementById("modalUpdateInputEmail").value = email;
    document.getElementById("modalUpdateInputcurricularUnit").value = curricularUnit;
  }

  function updateTurma(id,name,email,curricularUnit){
    document.getElementById("modalUpdateFormProfessor").action = "/teachers/update/" + id;
    document.getElementById("modalUpdateInputName").value = name;
    document.getElementById("modalUpdateInputEmail").value = email;
    document.getElementById("modalUpdateInputcurricularUnit").value = curricularUnit;
  }