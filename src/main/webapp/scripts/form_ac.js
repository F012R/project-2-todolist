var btn_reset = document.getElementById("btn-reset");
var name_label = document.getElementById("name");
var title_label = document.getElementById("title");
var btn_radio = document.getElementById("form-sequence");

btn_reset.addEventListener('click', (evt) => {
  name_label.value="";
  title_label.value="";
  let radio = document.querySelector('input[type=radio][name=sequence]:checked');
  radio.checked = false;
});

