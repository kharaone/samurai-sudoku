////////////////////////////////////////////////////////////////////////////////
//
//  Dodeka - Dodeka Sudoku solver.
//
//  Copyright (C) 2006	Bill Farmer
//
//  This program is free software; you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation; either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
//  Bill Farmer	 william j farmer [at] yahoo [dot] co [dot] uk.
//
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
//
//   Class Dodeka defines some puzzles from the Sunday Times and
//   solves them.
//
///////////////////////////////////////////////////////////////////////////////

public class Dodeka
{
    public static void main(String[] args)
    {
	// Create an instance.

	Dodeka dodeka = new Dodeka();

	// Define some puzzles.

	int[][] puzzle1 =
	    {{-1, 0,-1,-1,-1,-1, 8,-1, 7,-1, 3,-1},
	     {-1,-1,-1, 9,-1,-1,-1,-1, 5, 4,-1,-1},
	     {-1,-1,-1,-1,11, 4,-1,-1,-1,-1, 9, 0},
	     {-1, 2, 5,-1, 3,-1, 4,-1,-1, 1,-1,-1},
	     { 0,-1, 6,-1,-1,-1,-1,-1,-1,-1,10,-1},
	     {-1,-1,-1, 4, 5,-1, 9,-1, 6,-1,-1, 8},
	     { 7,-1,-1, 0,-1, 2,-1,11,10,-1,-1,-1},
	     {-1,10,-1,-1,-1,-1,-1,-1,-1, 7,-1, 4},
	     {-1,-1,11,-1,-1, 1,-1, 9,-1, 8, 2,-1},
	     {10, 3,-1,-1,-1,-1,11, 6,-1,-1,-1,-1},
	     {-1,-1, 4, 7,-1,-1,-1,-1, 8,-1,-1,-1},
	     {-1,11,-1, 5,-1, 3,-1,-1,-1,-1, 6,-1}};

	int[][] puzzle2 =
	    {{ 3,-1,-1,-1,-1,-1, 2,-1,-1,10,-1, 1},
	     {-1,-1,-1,11,-1,-1, 0,-1, 9, 5,-1,-1},
	     {-1,-1,-1,-1, 1,-1, 9,-1,-1,-1, 8, 6},
	     {-1, 5,-1,-1,-1, 6,-1,11, 1, 4,-1,-1},
	     {-1, 0,10,-1,-1,-1,-1, 8,-1,-1,-1, 9},
	     {11,-1,-1,-1,-1,-1, 4,-1,-1,-1, 7, 0},
	     {10,11,-1,-1,-1, 9,-1,-1,-1,-1,-1, 2},
	     { 9,-1,-1,-1, 7,-1,-1,-1,-1, 8, 5,-1},
	     {-1,-1, 7, 5, 3,-1,11,-1,-1,-1, 9,-1},
	     { 7, 3,-1,-1,-1, 2,-1, 0,-1,-1,-1,-1},
	     {-1,-1, 6,10,-1,11,-1,-1, 0,-1,-1,-1},
	     { 2,-1, 1,-1,-1, 7,-1,-1,-1,-1,-1, 4}};

	int[][] puzzle3 =
	    {{-1, 3, 8,-1,-1, 4,11,-1,-1,10, 2,-1},
	     {-1,-1,-1,10,-1,-1,-1,-1, 7,-1,-1,-1},
	     {-1, 9,-1,-1,10,-1,-1, 7,-1,-1, 6,-1},
	     {-1, 7,-1, 3, 4, 6, 1, 9,11,-1, 0,-1},
	     {-1,-1, 9,-1, 5,-1,-1,10,-1, 7,-1,-1},
	     { 2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 6},
	     { 0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 8},
	     {-1,-1,10,-1, 9,-1,-1, 1,-1, 4,-1,-1},
	     {-1, 4,-1, 7, 2, 5, 0, 8, 9,-1, 1,-1},
	     {-1, 8,-1,-1, 6,-1,-1, 4,-1,-1,10,-1},
	     {-1,-1,-1, 0,-1,-1,-1,-1, 2,-1,-1,-1},
	     {-1,10, 6,-1,-1, 9, 3,-1,-1, 5, 4,-1}};

	int[][] puzzle4 =
	    {{-1, 8,-1,-1, 9,-1,-1,-1,-1, 5, 7,-1},
	     {-1,-1,11,-1,-1,-1,-1,-1,-1,-1,-1, 0},
	     {-1, 4, 1, 5,-1, 2, 8,-1,-1,-1,-1,-1},
	     {10,-1,-1,-1,-1,-1,-1, 6, 3,-1,-1,-1},
	     { 2,-1, 5,-1,11,10,-1, 4,-1, 9,-1,-1},
	     {-1, 7, 4,-1, 1, 9,-1,-1, 6,-1,-1,-1},
	     {-1,-1,-1, 2,-1,-1, 9, 1,-1, 4, 5,-1},
	     {-1,-1, 9,-1, 4,-1,10, 5,-1, 1,-1, 2},
	     {-1,-1,-1, 4, 6,-1,-1,-1,-1,-1,-1,10},
	     {-1,-1,-1,-1,-1,11, 0,-1, 7, 2, 4,-1},
	     { 1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1},
	     {-1, 3, 8,-1,-1,-1,-1,10,-1,-1, 9,-1}};

	// Solve them.

	dodeka.solve(puzzle1);
	dodeka.solve(puzzle2);
	dodeka.solve(puzzle3);
	dodeka.solve(puzzle4);
    }

    // Solve a puzzle.

    void solve(int[][] puzzle)
    {
	// Create a new Dancing Links.

	DancingLinks dl = new DancingLinks(puzzle);

	// Print the puzzle for checking.

	report(puzzle);

	// Solve it.

	dl.solve(this);
    }

    // Print a puzzle or solution.

    void report(int[][] result)
    {
	for (int i = 0; i < PUZZLE_SIDE; i++)
	{
	    for (int j = 0; j < PUZZLE_SIDE; j++)

		// Print a '.' if empty.

		if (result[i][j] < 0)
		    System.out.print(". ");

	        // Else a dodeka digit in upper case.

		else
		    System.out.print(Integer.toString(result[i][j],
						      12).toUpperCase() + " ");

	    System.out.println();
	}

	System.out.println("-----------------------");
    }

///////////////////////////////////////////////////////////////////////////////
//
//  Define constants for the dimensions of the puzzle.
//
///////////////////////////////////////////////////////////////////////////////

    static final int PUZZLE_SIDE = 12;
    static final int SQUARE_SIZE = 4;
    static final int SQUARE_SIDE = 3;
    static final int PUZZLE_SIZE = 144;
    static final int COLUMN_SIZE = 576;

///////////////////////////////////////////////////////////////////////////////
//
//  Class DancingLinks implements the Dancing Links algorithm adapted
//  for Sudoku puzzles.
//
///////////////////////////////////////////////////////////////////////////////

    class DancingLinks
    {
	Dodeka dodeka;
	boolean stop;
	int[] stats;
	int index;
	Column h;
	Node[] o;

	// Create a column head and add 576 (144 x 4) columns. 1728
	// (12 x 12 x 12) rows of four nodes are added to the
	// columns. If a row is part of the puzzle it is removed from
	// the matrix and added to the solution.

	DancingLinks(int[][] p)
	{
	    // Column row head.

	    h = new Column(null, 0);
	    Column[] m = new Column[COLUMN_SIZE];

	    // Create the row of columns.

	    for (int i = 0; i < COLUMN_SIZE; i++)
		m[i] = new Column(h, 0);

	    // List of rows that are part of the solution.

	    Node[] l = new Node[PUZZLE_SIZE];
	    int i = 0;

	    // For each row, column and possible digit.

	    for (int r = 0; r < PUZZLE_SIDE; r++)
		for (int c = 0; c < PUZZLE_SIDE; c++)
		    for (int d = 0; d < PUZZLE_SIDE; d++)
		    {
			// Calculate row number.

			int k = (r * PUZZLE_SIZE) + (c * PUZZLE_SIDE) + d;

			// Create the row of nodes.

			Node n = new Node(m[(r * PUZZLE_SIDE) + c], k);
			n.add(new Node(m[(PUZZLE_SIZE * 1) +
					 (r * PUZZLE_SIDE) + d], k));
			n.add(new Node(m[(PUZZLE_SIZE * 2) +
					 (c * PUZZLE_SIDE) + d], k));
			n.add(new Node(m[(PUZZLE_SIZE * 3) +
					 ((((r / SQUARE_SIZE) * SQUARE_SIZE) +
					   (c / SQUARE_SIDE)) * PUZZLE_SIDE) +
					 d], k));

			// If this row is in the puzzle, add it to the
			// list.

			if (p[c][r] == d)
			    l[i++] = n;
		    }

	    // Create an array for the output.

	    o = new Node[PUZZLE_SIZE];

	    // Remove the rows in the list and add them to the output.

	    for (int j = 0; j < i; j++)
	    {
		l[j].remove();
		o[index++] = l[j];
	    }

	    // Create an array for the stats.

	    stats = new int[PUZZLE_SIZE];
	}

	// Rearrange the output to match the puzzle.

	void report(int[] o)
	{
	    // Create an array for the result.

	    int a[][] = new int[PUZZLE_SIDE][PUZZLE_SIDE];

	    // Convert the row number back to row, column, digit.

	    for (int i = 0; i < PUZZLE_SIZE; i++)
	    {
		int v = o[i];

		int d = v % PUZZLE_SIDE;
		int c = (v / PUZZLE_SIDE) % PUZZLE_SIDE;
		int r = (v / PUZZLE_SIZE) % PUZZLE_SIDE;

		a[c][r] = d;
	    }

	    // Report the result.

	    dodeka.report(a);

	    // Create an array for the stats.

	    int s[][] = new int[PUZZLE_SIDE][PUZZLE_SIDE];

	    for (int i = 0; i < PUZZLE_SIZE; i++)
		s[i / PUZZLE_SIDE][i % PUZZLE_SIDE] = stats[i];

	    // Report stats.

	    dodeka.report(s);
	}

	// Start the search process.

	void solve(Dodeka d)
	{
	    dodeka = d;
	    search(index);
	}

	// This is the procedure search(k) from the Dancing Links
	// algorithm with an added feature to report only one
	// solution.

	void search(int k)
	{
	    // If a result has already been found, return.

	    if (stop)
		return;

	    // If there are no more columns, report the result.

	    if (h.r == h)
	    {
		int[] a = new int[k];

		// Extract the row numbers.

		for (int i = 0; i < k; i++)
		    a[i] = o[i].n;

		// Report the result and set the stop flag.

		report(a);
		stop = true;
	    }

	    // Else find the shortest column and cover it.

	    else
	    {
		Column c = null;
		int s = Integer.MAX_VALUE;

		// Increment stats;

		stats[k]++;

		// Find the shortest column.

		for (Column j = (Column) h.r; j != h; j = (Column) j.r)
		    if (s > j.s)
		    {
			c = j;
			s = j.s;
		    }

		// Cover it.

		c.cover();

		// For each row in the column...

		for (Node r = c.d; r != c; r = r.d)
		{
		    // Skip this if a result has been found.

		    if (stop)
			break;

		    // Save the row in the output array.

		    o[k] = r;

		    // For each node in this row, cover it's column.

		    for (Node j = r.r; j != r; j = j.r)
			j.c.cover();

		    // Recurse with k + 1.

		    search(k + 1);

		    // For each node in this row, uncover it's column.

		    for (Node j = r.l; j != r; j = j.l)
			j.c.uncover();
		}

		// Uncover the column.

		c.uncover();
	    }
	}
    }

///////////////////////////////////////////////////////////////////////////////
//
//  Class Node has four links: left, right, up, down, which reference
//  adjacent nodes, a link which references the column and a row
//  number.
//
///////////////////////////////////////////////////////////////////////////////

    class Node
    {
	Node l;
	Node r;
	Node u;
	Node d;
	Column c;
	int n;

	// Create a self referencing node.

	Node(Column c, int n)
	{
	    this.l = this;
	    this.r = this;

	    this.u = this;
	    this.d = this;

	    // Column and row number.

	    this.c = c;
	    this.n = n;

	    // If the column isn't null, add this node to it.

	    if (c != null)
		c.add(this);
	}
 
	// Remove a row of nodes.

	void remove()
	{
	    Node n = this;

	    // Cover this node's column and move on to the next right.

	    do
	    {
		n.c.cover();
		n = n.r;
	    }

	    // While we haven't got back to this node.

	    while (n != this);
	}

	// Add a node to the left of this node.

	void add(Node n)
	{
	    n.l = this.l;
	    n.r = this;

	    this.l.r = n;
	    this.l = n;
	}
    }

///////////////////////////////////////////////////////////////////////////////
//
//  Class Column inherits the links from the Node class and has a column size.
//
///////////////////////////////////////////////////////////////////////////////

    class Column extends Node
    {
	int s;

	// Create a self referencing column using the Node constructor.

	Column(Column c, int n)
	{
	    super(null, n);

	    // If the column isn't null, add this one to it.

	    if (c != null)
		c.add(this);
	}

	// This is the procedure cover(c) from the Dancing Links
	// algorithm.

	void cover()
	{
	    // Cover this column.

	    r.l = l;
	    l.r = r;

	    // For all the rows in this column going down...

	    for (Node i = d; i != this; i = i.d)

		// For all the nodes in this row except this one,
		// going right...

		for (Node j = i.r; j != i; j = j.r)
		{
		    // Cover this row.

		    j.u.d = j.d;
		    j.d.u = j.u;

		    // Adjust the column size.

		    j.c.s--;
		}
	}

	// This is the procedure uncover(c) from the Dancing Links
	// algorithm.

	void uncover()
	{
	    // For all the rows in this column going up...

	    for (Node i = u; i != this; i = i.u)

		// For all the nodes in this row except this one,
		// going left...

		for (Node j = i.l; j != i; j = j.l)
		{
		    // Uncover this row.

		    j.u.d = j;
		    j.d.u = j;

		    // Adjust the size.

		    j.c.s++;
		}

	    // Uncover this column.

	    r.l = this;
	    l.r = this;
	}

	// Add a column to the left of this column.

	void add(Column c)
	{
	    c.l = this.l;
	    c.r = this;

	    this.l.r = c;
	    this.l = c;
	}

	// Add a node to the end of this column.

	void add(Node n)
	{
	    n.u = this.u;
	    n.d = this;

	    this.u.d = n;
	    this.u = n;

	    // Increment the column size.

	    s++;
	}
    }
}

///////////////////////////////////////////////////////////////////////////////
