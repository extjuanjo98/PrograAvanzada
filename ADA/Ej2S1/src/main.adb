with Text_IO;

procedure Main is
   subtype RangoInt is Integer range 0..10;
   nat:RangoInt;

   package Entero_IO is new Text_IO.Integer_IO(Integer);

begin
         Text_IO.Put_Line("Introduce  un natural:");
         Entero_IO.Get(nat);
         Text_IO.New_Line;
         Text_IO.Put("El Natural leido: ");
         Entero_IO.Put(nat);
         Text_IO.New_Line;

end Main;
