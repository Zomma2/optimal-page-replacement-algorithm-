import java.util.ArrayList;

public class OptimalAlgorithm {
	int hit  = 0 ; 
	int pageFault =0 ; 
public OptimalAlgorithm(int size, ArrayList<Integer> referenceString ) {

	frame f1 = new frame (size);
	for(int i=0 ; i<referenceString.size() ; i++)
	{
		if(!f1.isFull&&!f1.frameList.contains(referenceString.get(i)))
		{
			f1.addToFrame(referenceString.get(i));
			pageFault++ ;
		}
		
		else if (f1.frameList.contains(referenceString.get(i)))
		{
		hit ++ ; 
		}
		
		else 
		{	
			ArrayList<Integer> FuturePages = new ArrayList<Integer>(); 
			
			for (int j =i+1 ;j<referenceString.size();j++)
			{
				FuturePages.add(referenceString.get(j)) ;
				
			}
			
			
			
			int mostFar = 0 ; 
			 int elementTobeReplaced = 0 ;
				 for (int k =0 ; k<f1.frameList.size() ; k++)
				 {
					 
				int	temp = FuturePages.indexOf(f1.frameList.get(k)) ;
					if(mostFar<= temp )
					{
						mostFar = temp ; 
						elementTobeReplaced = k ;
					}
					else if (temp == -1 )
					{
						elementTobeReplaced = k ; 
						break ;
					}
					
					
					
				 }
				 
				 
				 f1.replacePage(elementTobeReplaced,referenceString.get(i));
				 pageFault++ ;
			
			
			
			
			
			
		}
	
	for(int Z =0 ; Z<f1.frameList.size() ; Z++)
	{
		System.out.print(f1.frameList.get(Z)+"\t");
		
	}
	System.out.println();
	}
	
	
	
	
	
	
}

public static void main(String[] args) {
	ArrayList<Integer> ref = new ArrayList<Integer>();  
	ref.add(2) ; 
	ref.add(3) ;
	ref.add(4) ;
	ref.add(2) ;
	ref.add(1) ;
	ref.add(3) ;
	ref.add(7) ;
	ref.add(1) ;
	ref.add(4) ;
	ref.add(3) ;
	for(Integer M: ref)
	{
		System.out.print(M+"\t") ;
	}
	System.out.println();
	System.out.println();
	OptimalAlgorithm o = new OptimalAlgorithm(3,ref);

	System.out.println("there is " +o.pageFault+" page faults ");

	
	
}
}
