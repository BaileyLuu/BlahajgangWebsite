import './App.css';
import { Col, Row, Container, Navbar, Card, Button, Table, Carousel, CarouselItem, Tab, Tabs, Sonnet } from 'react-bootstrap';
function App() {
  return (
    <div className="App">
       <Navbar bg="dark" variant="dark" className="my-nav">
    <Navbar.Brand href="#home">
      Blahajgang x MELONsquad
    </Navbar.Brand>
  </Navbar>
  
  <Container>
    <Row >
    <Col xs={12} md={8} >
      <h1>Welcome to Blahajgang!</h1>
    <p>Blahajgang x MELONsquad is a very active guild. Our leader of Blahajgang is Jacklyn and leader of MELONsquad is Adam. 
      We support one another and most important, we love Blahaj and make memes! We are currently #1 guild with over 11,000 points!
      We are not alone because we help each other to complete the challenges! 
      
    </p>

    <Carousel className="gallery"> Blahaj's Gallery
  <Carousel.Item>
    <img
      className="d-block w-100"
      src="https://blahajgang.lol/assets/just-blahaj.png"
      alt="First slide"
    />
    <Carousel.Caption>
      <p id="captionPic" >This is our guild mascot</p>
    </Carousel.Caption>
  </Carousel.Item>
  <Carousel.Item>
    <img
      className="d-block w-100"
      src="https://www.sadanduseless.com/wp-content/uploads/2018/10/ikea-shark2.jpg"
      alt="Second slide"
    />

    <Carousel.Caption>
    </Carousel.Caption>
  </Carousel.Item>
  </Carousel>

<h2>Bob Ross's Painting</h2>
  <Carousel className="gallery2"> 
  <Carousel.Item>
    <img
      className="d-block w-100"
      src="https://cdn.discordapp.com/attachments/826119794918817832/827297437470425118/Screenshot_2021-04-01_at_10.44.26_PM.png"
    
    />
    <Carousel.Caption>
      <h3>Adam</h3>
      <p id="captionPic" ></p>
    </Carousel.Caption>
  </Carousel.Item>
  <Carousel.Item>
    <img
      className="d-block w-100"
      src="https://www.pixenli.com/image/wWAqHisz"
     
    />

    <Carousel.Caption>
      <h3>c_compsci</h3>
  
    </Carousel.Caption>
  </Carousel.Item>
  <Carousel.Item>
    <img
      className="d-block w-100"
      src="https://cdn.discordapp.com/attachments/826119794918817832/827314040026955796/Bob_Ross_Drawing.png"
      
    />

    <Carousel.Caption>
      <h3>Xam</h3>
  
    </Carousel.Caption>
  </Carousel.Item>
  </Carousel>
    <h1>LHD:Share Top 3 Guilds</h1>
    <Table striped bordered hover>
  <thead>
    <tr>
      <th>Rank</th>
      <th>Guild Name</th>
      <th>Points</th>
      <th>Members</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>BLAHAJgang</td>
      <td>10,846</td>
      <td>318</td>
    </tr>
    <tr>
      <td>2</td>
      <td>EddieHub</td>
      <td>6,213</td>
      <td>278</td>
    </tr>
    <tr>
      <td>3</td>
      <td>Developer Student Community</td>
      <td>4,948</td>
      <td>248</td>
    </tr>
  </tbody>
</Table>
    </Col>
    <Col xs={12} md={4} >

      <Card className="attendLHD" style={{ width: '18rem' }}>
      <Card.Img variant="top" src="https://uploads-ssl.webflow.com/5f2c6dba183e4e456dfef9ac/600fdb222e63d00fa67bebc4_2020-LHD-share-for-web-01.png" />
    <Card.Body>
      <Card.Title>Attend Local Hack Day</Card.Title>
      <Card.Text>
       Remember to join Blahajgang.
       
      </Card.Text>

    <Button className="registerButton" variant="primary" href="https://organize.mlh.io/participants/events/6430-local-hack-day-share" target="popup">Click to register</Button>
    <Button className="scheduleButton" variant="primary" href="https://localhackday.mlh.io/#schedule" target="popup">Check the schedule</Button>

    
  
    </Card.Body>
      </Card>

      <Card className="MLHSocialMedia" style={{ width: '18rem' }}>
      <Card.Img variant="top" src="https://mlh.io/assets/logos/mlh-facebook-ae6144c0a3605f15992ee2970616db8d.jpg" />
    <Card.Body>
      <Card.Title>MLH's Social Media</Card.Title>
      <Card.Text>
       MLH has given us a great hacking experience, so remember to follow them on their social media for more hackathon events! 
       
      </Card.Text>

      
    <Button className="MLHButton" variant="primary" href="https://mlh.io" target="popup">MLH's Official Website</Button>
    <Button className="twitterButton" variant="primary" href="https://twitter.com/MLHacks" target="popup">Twitter</Button>
    <Button className="instagramButton" variant="primary" href="https://www.instagram.com/mlhacks/?hl=en" target="popup">Instagram</Button>
    <Button className="facebookButton" variant="primary" href="https://www.facebook.com/MajorLeagueHacking/" target="popup">Facebook</Button>
    <Button className="linkedInButton" variant="primary" href="https://www.linkedin.com/company/major-league-hacking/" target="popup">LinkedIn</Button>

    

  
  
    </Card.Body>
      </Card>
      <Card className="SocialMedia" style={{ width: '18rem' }}>
      <Card.Img variant="top" src="https://clipartstation.com/wp-content/uploads/2017/11/semangka-clipart-1.jpg" />
    <Card.Body>
      <Card.Title>Blahajgang's Social Media</Card.Title>
      <Card.Text>
       Join us in Discord and official website of our guild
       
      </Card.Text>

    <Button className="discordButton" variant="primary" href="https://discord.gg/sju7hAxaKZ" target="popup">Discord link</Button>
    <Button className="officialWebButton" variant="primary" href="https://melon.blahajgang.lol/#melon" target="popup">Official Website</Button>

  
  
    </Card.Body>
      </Card>


    </Col>
      
    </Row>
  </Container>
  
    </div>

  );
}

export default App;
