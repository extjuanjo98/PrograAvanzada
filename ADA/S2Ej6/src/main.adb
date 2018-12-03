with Text_IO;

procedure Main is
   num1 : Integer;
   num2 : Integer;
   package Integer_IO is new Text_IO.Integer_IO(Natural);
   package Float_IO is new Text_IO.Float_IO(Float);

   function mcd(num1 : in Integer;num2: in Integer)return Integer is
   begin
      if(num2=0)then
         return num1;
      else
         return mcd(num2,num1 mod num2);
      end if;
   end mcd;

begin
   Text_IO.Put("Introduce el numero 1: ");
   Integer_IO.Get(num1);

   Text_IO.Put("Introduce el numero 2: ");
   Integer_IO.Get(num2);
   num1:=mcd(num1,num2);
   Integer_IO.Put(num1);
end Main;
