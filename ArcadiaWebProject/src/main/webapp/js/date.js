function dateVeryfy(x1,x2)
{
 
    if (x1>=x2)
    {
        alert( " Sorry, wrong date entered!" );
		event.preventDefault();
		return 0;
		
		
    } else {
		
		
		return 1;
		
	}
    
}

function formatDate(date) {

					  var dd = date.getDate();
					  if (dd < 10) dd = '0' + dd;

					  var mm = date.getMonth() + 1;
					  if (mm < 10) mm = '0' + mm;

					  var yy = date.getFullYear() % 100;
					  if (yy < 10) yy = '0' + yy;

					  return dd + '.' + mm + '.' + yy;
					}
