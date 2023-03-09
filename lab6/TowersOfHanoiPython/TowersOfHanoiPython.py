def towersOfHanoi(n, from_rod, to_rod, aux_rod):
  if n == 1:
    print("Move disk 1 from rod " + from_rod + " to rod " + to_rod)
    return
  towersOfHanoi(n-1, from_rod, aux_rod, to_rod)
  print(f"Move disk {n} from rod {from_rod} to rod {to_rod}")
  towersOfHanoi(n-1, aux_rod, to_rod, from_rod)
  

print("\n\nRecursion Example Results")
towersOfHanoi(4, 'A', 'B', 'C')
