with Ada.Text_IO;
with Text_IO;

package body Monitor is
   package Integer_IO is new Text_IO.Integer_IO(Integer);

   protected body variableControl is

      entry pedirTurno
        when nPasajeros<4 and bajar=False is
      begin
         nPasajeros:=npasajeros+1;
         Text_IO.Put_Line("Que Fiesta!!!");
      end pedirTurno;

      entry entrarAtraccion
        when nPasajeros=4 is
      begin
         Text_IO.Put_Line("Que Divertido!!!");
         salir:=salir+1;
      end entrarAtraccion;

      entry salirAtraccion
        when salir=4 or bajar=True is
      begin
         bajar:=True;
         Text_IO.Put_Line("Me bajo");
         nPasajeros:=nPasajeros-1;
         salir:=salir-1;
         if(nPasajeros=0)then
            bajar:=False;
         end if;
      end salirAtraccion;


   end variableControl;
end Monitor;
