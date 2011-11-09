namespace VeryBroken 
{
    public class Name { 
	public String First { get; set; } 
	public String Last { get; set; } 
    }

    public class Person {
	public Person(Name name, List<Person> children) 
	{
	    this.Name = name; 
	    this.Children =  children; 
	}
	public Name Name { get; set; }
	public List<Person> Children { get; }
    }
}

public class Example {
    public void StateIsSpaghetti()
    {
	var children = new List<Person>();
	var alpha = new Person(new Name(“Alpha”, “Sister”), children);
	var beta  = new Person(new Name(“Beta”, “Sister”), children);

	alpha.Name.Last = “Omega”;
	alpha.Children.Add(new Person(new Name(“Gamma”, “Alphadaughter”)));
	DoSomethingTo(alpha, beta);
    }
}


namespace Improved 
{
    public class Name { 
	public String First { get; set; } 
	public String Last { get; set; } 
    }

    public class Person {
	public Person(Name name, List<Person> children) 
	{ 
	    this.name = name.DeepClone(); 
	    this.children =  DeepClone(children); 
	}
	public Name Name { get; set; }
	public IEnumerable<Person> Children { get { return DeepClone(children); }}
	public Name UpdateName(String f, String l) { this.Name = new Name(f,l); }
	public AddChild(Person child) { this.children.Add(child.DeepClone()); }
    }
}

