with Text_IO;

procedure Main is
   subtype probabilidad is Float range 0.0..1.0;
   nat:probabilidad;
   reale:Float;

   package Real_IO is new Text_IO.Float_IO(Float);

begin
   Text_IO.Put_Line("Introduce  un Real del 0 al 1:");
   Real_IO.Get(reale);
   nat:=reale;
   Text_IO.New_Line;
   Text_IO.Put("El Real leido: ");
   Real_IO.Put(nat);
   Text_IO.New_Line;

end Main;
