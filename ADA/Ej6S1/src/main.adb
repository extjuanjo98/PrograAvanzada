with Text_IO;

procedure Main is
   numero : String(1..4);
   num : Float;
   package Float_IO is new Text_IO.Float_IO(Float);
begin
   Text_IO.Put("Introduce el string a ser convertido: ");
   Text_IO.Get(inputString);
   num := Float'Value(numero);
   num := num*2.0;
   Float_IO.Put(num);
end Main;
