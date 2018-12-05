with Text_IO;
with Ada.Real_Time;
use Ada.Real_Time;
with Monitor;
use Monitor;


procedure Main is
   package int_IO is new Text_IO.Integer_IO(Integer);
   task type Control;
   Controlador:codigoControlador;


   task body Control is
      NextRealese:Time;
      ReleaseInterval:constant Time_Span:=Milliseconds(5000);
      code:Integer;
   begin

      NextRealese:=Ada.Real_Time.Clock;
      NextRealese:=NextRealese+ReleaseInterval;
         loop
           Controlador.generar(code);
           delay until NextRealese;
           NextRealese:=NextRealese+ReleaseInterval;
         end loop;
   end Control;



   t:Control;
   codigo:Integer;
begin
   loop
      Text_IO.Put_Line("Introduce un codigo");
      int_IO.Get(codigo);
      Controlador.validar(codigo);
   end loop;
end Main;
