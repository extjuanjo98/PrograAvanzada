with Text_IO;
with Ada.Command_Line;

procedure Main is

   package Integer_IO is new Text_IO.Integer_IO(Integer);

begin
   Text_IO.Put("Este programa se llama ");
   Text_IO.Put(ada.Command_Line.Command_Name);
   Text_IO.Put("y ha recibido ");
   Integer_IO.Put(ada.Command_Line.Argument_Count);
   Text_IO.Put_Line(" parametros.");
   Text_IO.Put_Line("Los argumentos son:");
   for i in 1..ada.Command_Line.Argument_Count loop
      Text_IO.Put(ada.Command_Line.Argument(i)&" ");
   end loop;

end Main;
