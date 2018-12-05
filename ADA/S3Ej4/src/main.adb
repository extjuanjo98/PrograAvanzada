with Text_IO;
with Ada; use Ada;
with Ada.Text_IO;

procedure Main is

   task type Servidor is
      entry sensor1(distancia:in Integer);
      entry sensor2(distancia:in out Integer);
   end Servidor;

   package Integer_IO is new Text_IO.Integer_IO(Integer);

   task body Servidor is
   begin
      loop
         select
            accept sensor1(distancia:in Integer) do
               Text_IO.Put_Line("Sensor1");
            end sensor1;

         or accept sensor2(distancia:in out Integer) do
               Text_IO.Put_Line("Sensor2");
               distancia:=distancia*2;
            end sensor2;
         or
           terminate;
         end select;
      end loop;
   end Servidor;
   t:Servidor;
   i:Integer;
begin
   i:=5;
   t.sensor1(i);
   Integer_IO.Put(i);
   Text_IO.Put_Line("");
   t.sensor2(i);
   Integer_IO.Put(i);
   Text_IO.Put_Line("");
   null;
end Main;
