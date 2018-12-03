with Text_IO;

procedure Main is
   max:constant Integer:=100;
   i :Integer;
   num :Integer;


   package Integer_IO is new Text_IO.Integer_IO(Integer);


begin
   i := 2;
   num := 2;
   --Bucle de iteracioes
   for i in 2..max/2
   loop
      num := num + i*2;
      Integer_IO.Put(num);
   end loop;

end Main;
