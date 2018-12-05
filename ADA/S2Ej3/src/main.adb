with Text_IO;



procedure Main is
   package Integer_IO is new Text_IO.Integer_IO(Integer);
   texto : String(1..14);
   indexletra : String(1 .. 14);
   num:  array (1..80) of Integer;
   indexnumeros :  array (1..14) of Integer :=(1,1,5,5,10,10,50,50,100,100,500,500,1000,1000);
   valor:Natural;
   total:Integer;
   cero:Integer;
begin

   indexletra :=('I','i','V','v','X','x','L','l','C','c','D','d','M','m');
   Text_IO.Put ("Escribe un numero romano:");
   Text_IO.Get_Line (texto, valor);
   total:=0;
   cero:=0;
   for i in 1..valor loop

      for j in 1..14 loop
         if texto(i)=indexletra(j) then
            num(i):= indexnumeros(j);
            num(i+1):=0;
         else

            null;
         end if;
      end loop;

   end loop;
   for i in 1..valor loop
      if num(i)<num(i+1) then
         total:=total-num(i);
      else
         total:=num(i)+total;
      end if;
	end loop;
   Integer_IO.Put(total);

end Main;
