import styled from "styled-components";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStackOverflow } from "@fortawesome/free-brands-svg-icons";
import { faGithub } from "@fortawesome/free-brands-svg-icons";
import { faPen } from "@fortawesome/free-solid-svg-icons";
import { faMessage } from "@fortawesome/free-regular-svg-icons";

const Container = styled.div`
  margin-top: 10px;
  height: auto;
  width: 200px;
  margin-right: 90px;
  @media all and (min-width: 1100px) and (max-width: 1490px) {
    width: 140px;
  }
  @media all and (min-width: 900px) and (max-width: 1100px) {
    width: 90px;
  }
  @media all and (min-width: 768px) and (max-width: 900px) {
    width: 50px;
  }
`;

const Inner = styled.div`
  position: fixed;
  @media all and (min-width: 1100px) and (max-width: 1490px) {
    width: 180px;
  }
  @media all and (min-width: 900px) and (max-width: 1100px) {
    width: 150px;
  }
  @media all and (min-width: 768px) and (max-width: 900px) {
    width: 130px;
  }
  @media all and (max-width: 768px) {
    display: none;
  }
`;
const Board = styled.section`
  filter: drop-shadow(1px 1px 1px rgba(0, 0, 0, 0.19));
  margin-bottom: 20px;
  width: 90%;
  &.first {
    background-color: #fdf7e2;
    height: 470px;
  }
  &.whiteboard {
    background-color: #ffff;
  }
  @media all and (min-width: 1100px) and (max-width: 1490px) {
    &.first {
      height: 500px;
    }
  }
  @media all and (min-width: 900px) and (max-width: 1100px) {
    &.first {
      height: 510px;
    }
  }
  @media all and (min-width: 768px) and (max-width: 900px) {
    &.first {
      height: 580px;
    }
  }
`;
const ItemHeader = styled.div`
  height: 32px;
  font-size: 14px;
  padding: 15px 0px 0px 6px;
  text-align: left;
  font-weight: 500;
  color: #3a3a3a;
  background-color: #f7f7f7;
  border-bottom: solid 1px rgb(166, 166, 166);
  &.first {
    background-color: #fbf3d5;
    border-bottom: solid 1px #eadcaf;
  }
  &.about {
    background-color: aliceblue;
  }
  @media all and (min-width: 1100px) and (max-width: 1490px) {
    height: 18px;
    padding-top: 8px;
  }
  @media all and (min-width: 900px) and (max-width: 1100px) {
    padding-top: 0px;
    height: 20px;
  }
  @media all and (min-width: 768px) and (max-width: 900px) {
    height: 20px;
    font-size: 12px;
    padding-top: 0;
  }
`;

const Item = styled.div`
  font-size: 12px;
  margin: 10px 0px 3px 5px;
  &.last {
    margin-bottom: 22px;
  }
  &.whitelast {
    height: 32px;
  }
  @media all and (min-width: 1100px) and (max-width: 1490px) {
    font-size: 11px;
  }
  @media all and (min-width: 900px) and (max-width: 1100px) {
    font-size: 7px;
  }
  @media all and (min-width: 768px) and (max-width: 900px) {
    font-size: 5px;
  }
`;

const ItemBody = styled.div`
  display: flex;
  align-items: center;
  padding-left: 5px;
`;

const AboutItem = styled.div`
  height: auto;
  font-size: 12px;
  margin: 7px;
  margin-bottom: 10px;
`;
const AboutText = styled.section`
  display: flex;
  flex-direction: column;
  margin-left: 14px;
  font-size: 12px;
  span:first-child {
    font-size: 18px;
  }
`;

const AboutTitle = styled.section`
  display: flex;
  justify-content: space-around;
  margin-top: 12px;
  section {
    display: flex;
    width: 170px;
    div {
      padding-top: 8px;
    }
  }
  button {
    width: 60px;
    border: solid 1px #44b1ff;
    background-color: #ffff;
    color: #5e99ff;
    border-radius: 5px;
    height: 50px;
    font-weight: 600;
    box-shadow: 1px 1px 1px #d6d7d8;
    :hover {
      background-color: #5e99ff;
      color: #fff;
    }
  }

  @media all and (min-width: 1100px) and (max-width: 1490px) {
    flex-direction: column;

    button {
      height: 30px;
      margin-left: 50px;
    }
  }
  @media all and (min-width: 900px) and (max-width: 1100px) {
    flex-direction: column;

    button {
      height: 30px;
      margin-left: 30px;
    }
  }
  @media all and (min-width: 768px) and (max-width: 900px) {
    flex-direction: column;

    button {
      height: 30px;
      margin-left: 20px;
    }
  }
`;

function RightBar() {
  return (
    <Container>
      <Inner>
        <Board className="first">
          <ItemHeader className="first">The Overflow Blog</ItemHeader>
          <ItemBody>
            <FontAwesomeIcon icon={faPen} color="gray" />
            <Item>
              What companies lose when they track worker productivity (Ep. 478)
            </Item>
          </ItemBody>
          <ItemBody>
            <FontAwesomeIcon icon={faPen} color="gray" />
            <Item className="last">
              Functional programming is an ideal fit for developing blockchains
            </Item>
          </ItemBody>
          <ItemHeader className="first">Featured on Meta</ItemHeader>
          <ItemBody>
            <FontAwesomeIcon icon={faMessage} color="#44b1ff" />
            <Item>
              Announcing the Stack Overflow Student Ambassador Program
            </Item>
          </ItemBody>
          <ItemBody>
            <FontAwesomeIcon icon={faMessage} color="#44b1ff" />
            <Item>Google Analytics 4 (GA4) upgrade</Item>
          </ItemBody>
          <ItemBody>
            <FontAwesomeIcon icon={faStackOverflow} />
            <Item>Staging Ground Workflow: Question Lifecycle </Item>
          </ItemBody>
          <ItemBody>
            <FontAwesomeIcon icon={faStackOverflow} />
            <Item className="last">The [option] tag is being burninated </Item>
          </ItemBody>
          <ItemHeader className="first">The Overflow Blog</ItemHeader>
          <Item className="last">
            17 &nbsp;&nbsp;Consolidating Python version-specific tags
          </Item>
        </Board>
        <Board className="whiteboard">
          <ItemHeader>Custom Filters</ItemHeader>
          <Item className="whitelast">Create a custom filter</Item>
        </Board>
        <Board className="whiteboard">
          <ItemHeader className="about">About Us</ItemHeader>
          <AboutItem>
            <AboutTitle>
              <section>
                <div>
                  <FontAwesomeIcon icon={faGithub} size="3x" />
                </div>
                <AboutText>
                  <span>Github</span>
                  <span>3 Members</span>
                </AboutText>
              </section>
              <a href="https://github.com/codestates-seb/seb39_pre_028/tree/dev">
                <button>Go</button>
              </a>
            </AboutTitle>

            <Item className="whitelast">Every commits for our project</Item>
          </AboutItem>
        </Board>
      </Inner>
    </Container>
  );
}

export default RightBar;
