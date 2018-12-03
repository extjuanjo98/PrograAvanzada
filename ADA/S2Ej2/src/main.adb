with Text_IO;

procedure Main is
   filas : Natural;
   columnas : Natural;
   package Integer_IO is new Text_IO.Integer_IO(Natural);
   package Float_IO is new Text_IO.Float_IO(Float);

   type matriz is array(Positive range <>, Positive range <>) of Float;

begin
   Text_IO.Put("Introduce el numero de filas: ");
   Integer_IO.Get(filas);

   Text_IO.Put("Introduce el numero de columnas: ");
   Integer_IO.Get(columnas);

   declare
      mat : matriz(1..filas, 1..columnas);
      inte : Integer;
   begin
      Text_IO.Put("Asignando numeros multiplos de 3.765 a la matriz... ");
      inte := 1;
      for i in 1..filas
      loop
         for j in 1..columnas
         loop
            mat(i,j) := 3.765 * float(inte);
            inte := inte + 1;
         end loop;
      end loop;

      Text_IO.Put_Line("");
      Text_IO.Put_Line("La matriz es: ");
      for i in 1..filas
      loop
         for j in 1..columnas
         loop
           Float_IO.Put( mat(i,j));
         end loop;
         Text_IO.Put_Line("");
      end loop;
   end;
end Main;
