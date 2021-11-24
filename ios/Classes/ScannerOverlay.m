#import "ScannerOverlay.h"

@interface ScannerOverlay()
  @property(nonatomic, retain) UIView *line;
@end

@implementation ScannerOverlay
  
  - (instancetype)initWithFrame:(CGRect)frame
  {
    self = [super initWithFrame:frame];
    if (self) {
      _line = [[UIView alloc] init];
      _line.backgroundColor = UIColor.redColor;
      _line.translatesAutoresizingMaskIntoConstraints = NO;
      [self addSubview:_line];
    }
    return self;
  }

    -(id)initWithFrameAndTheme:(CGRect)frame theme:(UIColor *)cornerColor
    {
        self = [super initWithFrame:frame];
        if (self) {
            self.cornerColor = cornerColor;
        }
        return self;
    }

- (void)drawRect:(CGRect)rect {
  CGContextRef context = UIGraphicsGetCurrentContext();
  
  UIColor * overlayColor = [UIColor colorWithRed:0.0 green:0.0 blue:0.0 alpha:0.55];
  
  CGContextSetFillColorWithColor(context, overlayColor.CGColor);
  CGContextFillRect(context, self.bounds);
  
  // make a hole for the scanner
  CGRect holeRect = [self scanRect];
  CGRect holeRectIntersection = CGRectIntersection( holeRect, rect );
  [[UIColor clearColor] setFill];
  UIRectFill(holeRectIntersection);
  
  // drw the green corners
  CGFloat cornerSize = 30;
  UIBezierPath *path = [UIBezierPath bezierPath];
  //top left corner
  [path moveToPoint:CGPointMake(holeRect.origin.x, holeRect.origin.y + cornerSize)];
  [path addLineToPoint:CGPointMake(holeRect.origin.x, holeRect.origin.y)];
  [path addLineToPoint:CGPointMake(holeRect.origin.x + cornerSize, holeRect.origin.y)];
  
  //top right corner
  CGFloat rightHoleX = holeRect.origin.x + holeRect.size.width;
  [path moveToPoint:CGPointMake(rightHoleX - cornerSize, holeRect.origin.y)];
  [path addLineToPoint:CGPointMake(rightHoleX, holeRect.origin.y)];
  [path addLineToPoint:CGPointMake(rightHoleX, holeRect.origin.y + cornerSize)];
  
  // bottom right corner
  CGFloat bottomHoleY = holeRect.origin.y + holeRect.size.height;
  [path moveToPoint:CGPointMake(rightHoleX, bottomHoleY - cornerSize)];
  [path addLineToPoint:CGPointMake(rightHoleX, bottomHoleY)];
  [path addLineToPoint:CGPointMake(rightHoleX - cornerSize, bottomHoleY)];
  
  // bottom left corner
  [path moveToPoint:CGPointMake(holeRect.origin.x + cornerSize, bottomHoleY)];
  [path addLineToPoint:CGPointMake(holeRect.origin.x, bottomHoleY)];
  [path addLineToPoint:CGPointMake(holeRect.origin.x, bottomHoleY - cornerSize)];
  
  path.lineWidth = 2;
  [self.cornerColor setStroke];
  [path stroke];
  
}
  
  - (CGRect)scanRect {
    CGRect rect = self.frame;
      CGFloat heightMultiplier = 1.0; // 1:1 aspect ratio
    CGFloat scanRectWidth = rect.size.width * 0.8f;
    CGFloat scanRectHeight = scanRectWidth * heightMultiplier;
    CGFloat scanRectOriginX = (rect.size.width / 2) - (scanRectWidth / 2);
    CGFloat scanRectOriginY = (rect.size.height / 2) - (scanRectHeight / 2);
    return CGRectMake(scanRectOriginX, scanRectOriginY, scanRectWidth, scanRectHeight);
  }

@end
