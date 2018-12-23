with Text_IO;
with Ada.Real_Time;
with Calendar;
use Calendar;

procedure Main is

   task type emisor;
   task type receptor is
      entry mensaje;
   end receptor;

   emisora:emisor;
   receptora:receptor;

task body emisor is
      inicio:Time;
      intervalo:Duration:=10.0;

begin
  select
	delay 120.0;
  then abort
        inicio:=Clock;
         loop
            Text_IO.Put_Line("Mensaje enviado :"&Calendar.Day_Duration'Image(Calendar.Seconds(Clock)-Calendar.Seconds(inicio)));
            receptora.mensaje;
            delay 10.0;
         end loop;
  end select;
end emisor;

 task body receptor is

 begin
  loop
         select
            accept mensaje do
               Text_IO.Put_Line("Mensaje recibido");
            end mensaje;
         or
            delay 15.0;
            exit;
         end select;
   end loop;
 end receptor;


begin

   null;

end Main;
