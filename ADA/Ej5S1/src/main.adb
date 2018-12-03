with Text_IO;

procedure Main is
   type probabilidad is digits 2 range 0.0..1.00;

   nat:probabilidad;

   package Real_IO is new Text_IO.Float_IO(Float);

begin
   nat:=0.5;
   nat:=0.005;
   nat:=2.00;
   nat:=0.00005;

end Main;
