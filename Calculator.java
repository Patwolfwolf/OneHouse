package com.example.ruiwen.onehouse;/* Generated By:JavaCC: Do not edit this line. Calculator.java */
import java.io.PrintStream ;
import java.io.StringReader;
import java.io.Reader;
import java.util.Scanner;

import static javax.xml.datatype.DatatypeConstants.EQUAL;

public class Calculator implements CalculatorConstants {
    double previousValue = 0.0 ;
//test
  final public double Start() throws ParseException, NumberFormatException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MINUS:
      case OPEN_PAR:
      case BEGINSOLVE:
      case BEGINSOLVE2:
      case NUMBER:
      case SIN:
      case COS:
      case TAN:
      case SQRT:
      case LOG10:
      case LN:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      previousValue = Expression();
      jj_consume_token(EOL);
          {if (true) return previousValue;}
    }
    jj_consume_token(0);
    throw new Error("Missing return statement in function");
  }

  final public double Expression() throws ParseException, NumberFormatException {
    double i;
    double value;
    value = Term();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        i = Term();
          value += i;
        break;
      case MINUS:
        jj_consume_token(MINUS);
        i = Term();
          value -= i;
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
      {if (true) return value;}
    throw new Error("Missing return statement in function");
  }

  final public double Term() throws ParseException, NumberFormatException {
    double i;
    double value;
    value = Primary();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TIMES:
      case DIVIDE:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TIMES:
        jj_consume_token(TIMES);
        i = Primary();
          value *= i;
        break;
      case DIVIDE:
        jj_consume_token(DIVIDE);
        i = Primary();
          value /= i;
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
      {if (true) return value;}
    throw new Error("Missing return statement in function");
  }

  final public double Equation() throws ParseException, NumberFormatException {
  double a,b;
  double value;
    value = Primary();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
      case EQUAL:
      case SOLVEX:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SOLVEX:
        jj_consume_token(SOLVEX);
        label_5:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PLUS:
          case MINUS:
          case EQUAL:
            ;
            break;
          default:
            jj_la1[6] = jj_gen;
            break label_5;
          }
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PLUS:
            jj_consume_token(PLUS);
            a = Primary();
            jj_consume_token(EQUAL);
            b = Primary();
         value = (b-a)/value;
            break;
          case MINUS:
            jj_consume_token(MINUS);
            a = Primary();
            jj_consume_token(EQUAL);
            b = Primary();
         value = (b+a)/value;
            break;
          case EQUAL:
            jj_consume_token(EQUAL);
            a = Primary();
         value = a/value;
            break;
          default:
            jj_la1[7] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
        break;
      case PLUS:
        jj_consume_token(PLUS);
        a = Primary();
        jj_consume_token(SOLVEX);
        jj_consume_token(EQUAL);
        b = Primary();
         value = (b-value)/a;
        break;
      case MINUS:
        jj_consume_token(MINUS);
        a = Primary();
        jj_consume_token(SOLVEX);
        jj_consume_token(EQUAL);
        b = Primary();
         value = (value-b)/a;
        break;
      case EQUAL:
        jj_consume_token(EQUAL);
        a = Primary();
        label_6:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PLUS:
          case MINUS:
          case SOLVEX:
            ;
            break;
          default:
            jj_la1[8] = jj_gen;
            break label_6;
          }
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case SOLVEX:
            jj_consume_token(SOLVEX);
            label_7:
            while (true) {
              switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
              case PLUS:
              case MINUS:
                ;
                break;
              default:
                jj_la1[9] = jj_gen;
                break label_7;
              }
              switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
              case PLUS:
                jj_consume_token(PLUS);
                b = Primary();
                 value = (value-b)/a;
                break;
              case MINUS:
                jj_consume_token(MINUS);
                b = Primary();
                 value = (value+b)/a;
                break;
              default:
                jj_la1[10] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
              }
            }
            break;
          case PLUS:
            jj_consume_token(PLUS);
            b = Primary();
         value = (value-a)/b;
            break;
          case MINUS:
            jj_consume_token(MINUS);
            b = Primary();
         value = (value+a)/b;
            break;
          default:
            jj_la1[11] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
   {if (true) return value;}
    throw new Error("Missing return statement in function");
  }

  final public double Equation2() throws ParseException, NumberFormatException {
  double a,b,c,d;
  double value1;
    a = Primary();
    jj_consume_token(SOLVEX2);
    jj_consume_token(PLUS);
    b = Primary();
    jj_consume_token(SOLVEX);
    jj_consume_token(PLUS);
    c = Primary();
    jj_consume_token(EQUAL);
    d = Primary();
   value1 = (-b+java.lang.Math.sqrt(b*b-4*a*c))/(2*a);
   {if (true) return value1;}
    throw new Error("Missing return statement in function");
  }

  final public double Primary() throws ParseException, NumberFormatException {
    Token t;
    double d;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      t = jj_consume_token(NUMBER);
      {if (true) return Double.parseDouble( t.image );}
      break;
    case BEGINSOLVE:
      jj_consume_token(BEGINSOLVE);
      d = Equation();
      jj_consume_token(ENDSOLVE);
      {if (true) return d;}
      break;
    case BEGINSOLVE2:
      jj_consume_token(BEGINSOLVE2);
      d = Equation2();
      jj_consume_token(ENDSOLVE);
          {if (true) return d;}
      break;
    case OPEN_PAR:
      jj_consume_token(OPEN_PAR);
      d = Expression();
      jj_consume_token(CLOSE_PAR);
      {if (true) return d;}
      break;
    case MINUS:
      jj_consume_token(MINUS);
      d = Primary();
      {if (true) return -d;}
      break;
    case SIN:
      jj_consume_token(SIN);
      jj_consume_token(OPEN_PAR);
      d = Expression();
      jj_consume_token(CLOSE_PAR);
      {if (true) return java.lang.Math.sin(d);}
      break;
    case COS:
      jj_consume_token(COS);
      jj_consume_token(OPEN_PAR);
      d = Expression();
      jj_consume_token(CLOSE_PAR);
        {if (true) return java.lang.Math.cos(d);}
      break;
    case TAN:
      jj_consume_token(TAN);
      jj_consume_token(OPEN_PAR);
      d = Expression();
      jj_consume_token(CLOSE_PAR);
                {if (true) return java.lang.Math.tan(d);}
      break;
    case SQRT:
      jj_consume_token(SQRT);
      jj_consume_token(OPEN_PAR);
      d = Expression();
      jj_consume_token(CLOSE_PAR);
                {if (true) return java.lang.Math.sqrt(d);}
      break;
    case LOG10:
      jj_consume_token(LOG10);
      jj_consume_token(OPEN_PAR);
      d = Expression();
      jj_consume_token(CLOSE_PAR);
                {if (true) return java.lang.Math.log10(d);}
      break;
    case LN:
      jj_consume_token(LN);
      jj_consume_token(OPEN_PAR);
      d = Expression();
      jj_consume_token(CLOSE_PAR);
                {if (true) return java.lang.Math.log(d);}
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public CalculatorTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x7e8690,0x18,0x18,0x60,0x60,0x3018,0x1018,0x1018,0x2018,0x18,0x18,0x2018,0x3018,0x7e8690,};
   }

  /** Constructor with InputStream. */
  public Calculator(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Calculator(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CalculatorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Calculator(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CalculatorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Calculator(CalculatorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CalculatorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[23];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 14; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 23; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

//    public static void main( String[] args )throws ParseException, TokenMgrError, NumberFormatException {
//		Scanner in = new Scanner(System.in);
//		String input = in.nextLine();
//        Calculator parser = new Calculator( input ) ;  
//        System.out.println(parser.Start()) ;  
//    }  
}
